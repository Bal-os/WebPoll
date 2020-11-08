package ua.prog.kiev;

import java.util.*;

public class QuestionList {
    private Map<String, int[]> questionsMap = new LinkedHashMap<>();
    private List<String> questionsKeyList = new ArrayList<>();

    public QuestionList(){ }

    public QuestionList(String ... questions) {
        if(questions != null) {
            for (String question: questions) {
                this.addQuestion(question);
            }
        }
    }

    private enum Answers{
        YES,
        NO
    }

    private String statToString(int[] arr){
        String result = "";
        if(Answers.values().length <= arr.length){
            boolean isFirstLine = true;
            for (var ans: Answers.values()) {
                if(!isFirstLine) {
                    result += ", ";
                } else isFirstLine = false;
                result += ans.toString() + " = " + arr[ans.ordinal()];
            }
        }
        return result;
    }

    private int[] getArray(String ans){
        int[] arr = new int[Answers.values().length];
        if(ans != null){
            addStatToArr(arr, ans);
        }
        return arr;
    }

    private void addStatToArr(int[] arr, String ans){
        try {
            arr[Answers.valueOf(ans.toUpperCase()).ordinal()]++;
        } catch (IllegalArgumentException e){}
    }

    public void addQuestion(String question){
        addQuestion(question, null);
    }

    public void addQuestion(String question, String ans){
        if (question != null) {
            if(!questionsMap.containsKey(question)) {
                questionsMap.put(question, getArray(ans));
                questionsKeyList.add(question);
            } else {
                addAnswer(question, ans);
            }
        }
    }

    public void addAnswer(String question, String ans){
        if (question != null) {
            addStatToArr(questionsMap.get(question), ans);
        }
    }

    public void addAnswer(int index, String ans){
        addAnswer(questionsKeyList.get(index), ans);
    }

    public String getQuestionStat(int index){
        return getQuestionStat(getQuestion(index));
    }

    public String getQuestionStat(String question){
        return statToString(questionsMap.get(question));
    }

    public String getQuestion(int index){
        if(index < questionsKeyList.size()) {
            return questionsKeyList.get(index);
        } else return null;
    }

    public int size(){
        return questionsKeyList.size();
    }

    @Override
    public String toString() {
        String result = "";
        for(String question: questionsKeyList){
            result += "<p>" + question + " : " + getQuestionStat(question) + "</p>";
        }
        return result;
    }
}
