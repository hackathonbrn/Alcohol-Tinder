package com.Drinker.recomendation;

import com.Drinker.model.Alcohol;
import com.Drinker.model.User;
import com.Drinker.repository.AlcoholRepo;
import com.Drinker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

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
    public List<HashMap<Integer, Integer>> getSortedRecomendations(int target) {
        HashMap<Integer, Integer> allRecomend = getRecomendation(target);
        List list = new ArrayList(allRecomend.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return list;
    }

    public List<HashMap<Integer, Integer>> getRecomendationByDrink(int target) {
        User targetUser = userRepo.findById(Long.valueOf(target)).get();
        List<Integer> allUserAlcohol = targetUser.getAlcohol();

        Iterable<User> allUsers = userRepo.findAll();
        // начинаем обход всех юзеров
        for (User concreteUser: allUsers) {
            if (concreteUser.getId() == targetUser.getId()) {
                continue;
            }
            List<Integer> concreteAlcoholList = concreteUser.getAlcohol();

        }
        return null;
    }

    /**
     *
     * @param concreteAlcoholList - список напитков юзера из последовательного обхода
     * @param targetAlcohollist - список напитков юзера, совпадения для которого мы ищем
     * @return
     */
    private int getCountOfMatches(List<Integer> concreteAlcoholList, List<Integer> targetAlcohollist) {
        int countOfMatches = 0;
        for (int targetAlcolol: targetAlcohollist) {
            for (int concreteAlcohol: concreteAlcoholList) {
                if (targetAlcolol == concreteAlcohol) {
                    countOfMatches++;
                    concreteAlcoholList.remove(concreteAlcohol);
                }
            }
        }
        return countOfMatches;
    }



}
