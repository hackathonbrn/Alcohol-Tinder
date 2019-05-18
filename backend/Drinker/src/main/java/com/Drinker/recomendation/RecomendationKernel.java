package com.Drinker.recomendation;

import com.Drinker.model.User;
import com.Drinker.repository.AlcoholRepo;
import com.Drinker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

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
    public List<Integer> getSortedRecomendations(Integer target) {
        HashMap<Integer, Integer> allRecomend = getRecomendation(target);
        HashMap<Integer, Integer> sortedRecomend = sortingDownList(allRecomend);

        return transformMapToList(sortedRecomend);
    }

    // сортировка мапы по убыванию
    public HashMap<Integer, Integer> sortingDownList(HashMap<Integer, Integer> sourceMap) {
        HashMap<Integer, Integer> sortedHashik  = sourceMap
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(
                        toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2)->e2, LinkedHashMap::new)
                );
        return sortedHashik;
    }

    // поиск рекомендаций по напиткам
    public List<Integer> getRecomendationByDrink(User targetUser, List<User> allUsers) {
        HashMap<Integer, Integer> resultUnsort = new HashMap<>();
//        User targetUser = userRepo.findById(target).get();
        List<Integer> allUserAlcohol = targetUser.getAlcohol();
//        Iterable<User> allUsers = userRepo.findAll();
        // начинаем обход всех юзеров
        for (User concreteUser: allUsers) {
            if (concreteUser.getId().equals(targetUser.getId())) {
                continue;
            }
            List<Integer> concreteAlcoholList = concreteUser.getAlcohol();
            int countOfMatches = getCountOfMatches(concreteAlcoholList, allUserAlcohol);
            // сохраним в итоговую мапу
            resultUnsort.put(concreteUser.getId(), countOfMatches);
        }
        List<Integer> sortedListRecomendation = transformMapToList(resultUnsort);
        return sortedListRecomendation;
    }

    // получение списка ключей из мапы в том же порядке
    public List<Integer> transformMapToList(HashMap<Integer, Integer> source) {
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (Integer key: source.keySet()) {
            sortedList.add(key);
        }
        return sortedList;
    }

    /**
     * Получения количества совпадений в листах
     * @param concreteAlcoholList - целочисленный список, integer список напитков юзера из последовательного обхода
     * @param targetAlcohollist - целочисленный список, список напитков юзера, совпадения для которого мы ищем
     * @return - количество совпадений
     */
    public int getCountOfMatches(List<Integer> concreteAlcoholList, List<Integer> targetAlcohollist) {
        int countOfMatches = 0;
        for (int i = 0; i < targetAlcohollist.size(); i++ ) {
            for (int j = 0; j < concreteAlcoholList.size(); j++) {
                if (targetAlcohollist.get(i).equals(concreteAlcoholList.get(j))) {
                    countOfMatches++;
                    concreteAlcoholList.remove(j);
                    j--;
                }
            }
        }
        return countOfMatches;
    }



}
