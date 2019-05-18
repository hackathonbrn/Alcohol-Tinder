package com.Drinker.recomendation;

import com.Drinker.model.User;
import com.Drinker.repository.AlcoholRepo;
import com.Drinker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static java.util.stream.Collectors.toMap;


/**
 * класс, содержащий в себе методы для поиска юзеров, которые должны быть в предложке
 */
public class RecomendationKernel {
    private Graph graph;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AlcoholRepo alcoholRepo;

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public RecomendationKernel(Graph graph) {
        this.graph = graph;
    }

    public RecomendationKernel() {

    }

    public boolean checkFirstStageInclude(ArrayList<Integer> firstStage, int targetNeighbour) {
        for (int neighbour: firstStage) {
            if (neighbour == targetNeighbour) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Integer> getFirstStageNeighbour(int target) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Edge edge: graph.getEdgeList()) {
            if (edge.getUser1() == target) {
                result.add(edge.getUser2());
            }
        }
        return result;
    }

    // поиск рекомендаций по друзьям
    public HashMap<Integer, Integer> getRecomendation(int target) {
        ArrayList<Integer> fiirstNeighbours = getFirstStageNeighbour(target);
        // получен список первых соседей, теперь требуется выявить среди них кандидатов

        // мутим мапу для фиксирования количества дринкеров у друзей
        HashMap<Integer, Integer> candidate = new HashMap<Integer, Integer>();
        for (int mainNeighbour: fiirstNeighbours) {
            ArrayList<Integer> secondStage = getFirstStageNeighbour(mainNeighbour);
            for (int secondNeighbour: secondStage) {
                if (secondNeighbour == target || checkFirstStageInclude(fiirstNeighbours, secondNeighbour)) {
                    continue;
                }
                if (candidate.get(secondNeighbour) == null) {
                    candidate.put(secondNeighbour, 1);
                } else {
                    candidate.put(secondNeighbour, candidate.get(secondNeighbour) + 1);
                }
            }
        }
        return candidate;
    }

    // получение упорядоченного по убыванию списка собутыльников
    public HashMap<Integer, Integer> getSortedRecomendations(int target) {
        HashMap<Integer, Integer> allRecomend = getRecomendation(target);
        HashMap<Integer, Integer> sortedRecomend = allRecomend
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new)
                );

        return sortedRecomend;
    }

    public List<Integer> sortingDownList(HashMap<Integer, Integer> sourseMap) {
        List list = new ArrayList(sourseMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        List<Integer> sortedHashik  = new ArrayList<>();
//        for (Ha)
        return null;

    }

    public List<HashMap<Integer, Integer>> getRecomendationByDrink(int target) {
        User targetUser = userRepo.findById(Long.valueOf(target)).get();
        List<Integer> allUserAlcohol = targetUser.getAlcohol();

        Iterable<User> allUsers = userRepo.findAll();
        // начинаем обход всех юзеров
        for (User concreteUser: allUsers) {
            if (concreteUser.getId().equals(targetUser.getId())) {
                continue;
            }
            List<Integer> concreteAlcoholList = concreteUser.getAlcohol();
            int countOfMatches = getCountOfMatches(concreteAlcoholList, allUserAlcohol);

        }
        return null;
    }

    /**
     * @param concreteAlcoholList - целочисленный список, integer список напитков юзера из последовательного обхода
     * @param targetAlcohollist - целочисленный список, список напитков юзера, совпадения для которого мы ищем
     * @return - количество совпадений
     */
    public int getCountOfMatches(List<Integer> concreteAlcoholList, List<Integer> targetAlcohollist) {
        int countOfMatches = 0;
        for (int i = 0; i < targetAlcohollist.size(); i++ ) {
            for (int j = 0; j < concreteAlcoholList.size(); j++) {
                if (targetAlcohollist.get(i) == concreteAlcoholList.get(j)) {
                    countOfMatches++;
                    concreteAlcoholList.remove(j);
                    j--;
                }
            }
        }
        return countOfMatches;
    }



}
