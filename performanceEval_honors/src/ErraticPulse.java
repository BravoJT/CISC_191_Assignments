import java.util.*;

public class ErraticPulse {
    private LinkedList<Integer> list;
    private ArrayList<Integer> arr;

    public ErraticPulse(int num, String mode) {
        int mills = num * 1000000;
        switch (mode) {
            case "both" -> {
                list = new LinkedList<>();
                arr = new ArrayList<Integer>();
                for (int i = 0; i < mills; i++) {
                    arr.add((int) (Math.random() * 100));
                    list.add((int) (Math.random() * 100));
                }
                break;
            }
            case "list" -> {
                list = new LinkedList<>();
                for (int i = 0; i < mills; i++) {
                    list.add((int) (Math.random() * 100));
                }
                break;
            }
            case "array" -> {
                arr = new ArrayList<Integer>();
                for (int i = 0; i < mills; i++) {
                    arr.add((int) (Math.random() * 100));
                }
                break;

            }
        }
    }

    public void run(String action, String target, String location) {
        switch (action) {
            case "add" -> {
                switch (target) {
                    case "array" -> {
                        switch (location) {
                            case "start" -> {
                                arr.addFirst((int) (Math.random() * 100));
                                break;
                            }
                            case "end" -> {
                                arr.addLast((int) (Math.random() * 100));
                                break;
                            }
                        }
                    }
                    case "list" -> {
                        switch (location) {
                            case "start" -> {
                                list.addFirst((int) (Math.random() * 100));
                                break;
                            }
                            case "end" -> {
                                list.addLast((int) (Math.random() * 100));
                                break;
                            }
                        }
                    }
                    case "both" -> {
                        switch (location) {
                            case "start" -> {
                                list.addFirst((int) (Math.random() * 100));
                                arr.addFirst((int) (Math.random() * 100));
                                break;
                            }
                            case "end" -> {
                                list.addLast((int) (Math.random() * 100));
                                arr.addLast((int) (Math.random() * 100));
                                break;
                            }
                        }
                    }
                }
            }
            case "remove" -> {
                switch (target) {
                    case "array" -> {
                        switch (location) {
                            case "start" -> {
                                arr.removeFirst();
                                break;
                            }
                            case "end" -> {
                                arr.removeLast();
                                break;
                            }
                        }
                    }
                    case "list" -> {
                        switch (location) {
                            case "start" -> {
                                list.removeFirst();
                                break;
                            }
                            case "end" -> {
                                list.removeLast();
                                break;
                            }
                        }
                    }
                    case "both" -> {
                        switch (location) {
                            case "start" -> {
                                list.removeFirst();
                                arr.removeFirst();
                                break;
                            }
                            case "end" -> {
                                list.removeLast();
                                arr.removeLast();
                                break;
                            }
                        }
                    }
                }
            }
            case "read" -> {
                switch (target) {
                    case "array" ->{
                        int num;
                        for(int i = 0;i<arr.size();i++)
                        {
                            num = arr.get(i);
                            System.out.println(num);
                        }
                        break;
                    }
                    case "list" ->{
                        int num;
                        ListIterator moon = list.listIterator();
                        while(moon.hasNext())
                        {
                            num = (int)moon.next();
                            System.out.println(num);
                        }
                        break;
                    }
                    case "both" ->{
                        int num;
                        for(int i = 0;i<arr.size();i++)
                        {
                            num = arr.get(i);
                            System.out.println(num);
                        }
                        ListIterator moon = list.listIterator();
                        while(moon.hasNext())
                        {
                            num = (int)moon.next();
                            System.out.println(num);
                        }
                       break;
                    }

                }
            }
        }
    }
}