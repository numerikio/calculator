package handlers.parsers;

import exceptions.WroteRomanNumbersException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanNumbersParser implements Parser {

    private String errorMessage1 = "Error target roman numbers string - ";
    private String errorMessage2 = "Error too many chars - ";

    private char[] allowedСhars = {'V', 'L', 'D', 'I', 'X', 'C', 'M'};
    private Map<String, Integer> map = new HashMap();

    public RomanNumbersParser() {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
    }

    @Override
    public Integer getNumber(String targetRomanNumbersString) {
        try {
            return getResult(getSingleNumbers(targetRomanNumbersString));
        } catch (WroteRomanNumbersException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Integer getResult(List<Integer> list) {
        Integer result = null;
        for (Integer integer : list
        ) {
            if (result != null) {
                result += integer;
            } else {
                result = integer;
            }
        }
        return result;
    }

    private List<Integer> getSingleNumbers(String targetString) throws WroteRomanNumbersException {
        String[] strings = findFaults(targetString).split("");
        List<Integer> list = null;
        list = new ArrayList();
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 1) {
                if (map.containsKey(strings[i] + strings[i + 1])) {
                    list.add(map.get(strings[i] + strings[i + 1]));
                    i++;
                    continue;
                }
                if (map.get(strings[i]) >= map.get(strings[i + 1])) {
                    list.add(map.get(strings[i]));
                } else {
                    list.add(-map.get(strings[i]));
                }
            } else {
                list.add(map.get(strings[i]));
            }
        }
        stringValid(list);
        return list;
    }

    private void stringValid(List<Integer> list) throws WroteRomanNumbersException {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) < list.get(i + 1)) {
                throw new WroteRomanNumbersException(errorMessage1 + i + " " + (i + 1));
            }
        }
    }

    private String findFaults(String targetString) throws WroteRomanNumbersException {
        char[] chars = targetString.toCharArray();
        findErrOfString(chars);
        int counter = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (counter < getLimitCounter(chars[i], chars[i + 1])) {
                if (chars[i] == chars[i + 1]) {
                    counter++;
                    if (chars[i] == chars[chars.length - 1]) {
                        counter++;
                    }
                } else {
                    counter = 0;
                }
            } else {
                throw new WroteRomanNumbersException(errorMessage2 + chars[i]);
            }
        }
        return targetString;
    }

    private int getLimitCounter(char a, char b) {
        int result;
        if (a == b && (a == allowedСhars[0] || a == allowedСhars[1] || a == allowedСhars[2])) {
            result = 0;
        } else { //if (a == b && (a == allowedСhars[3] || a == allowedСhars[4] || a == allowedСhars[5] || a == allowedСhars[6])) {
            result = 3;
        }
        return result;
    }

    private void findErrOfString(char[] chars) throws WroteRomanNumbersException {
        boolean flag = false;
        for (char c : chars
        ) {
            for (char c1 : allowedСhars
            ) {
                if (c1 == c) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                throw new WroteRomanNumbersException(errorMessage1 + c);
            }
        }
        findErrOfString2(chars);
    }

    private void findErrOfString2(char[] chars) throws WroteRomanNumbersException {
        for (int i = 0; i < chars.length - 2; i++) {
            if (map.get(String.valueOf(chars[i])) < map.get(String.valueOf(chars[i + 1]))) {
                if (map.get(String.valueOf(chars[i + 1])) > map.get(String.valueOf(chars[i + 2]))) {
                    throw new WroteRomanNumbersException(errorMessage1 + chars[i] + chars[i + 1] + chars[i + 2]);
                }
            }
        }
    }
}
