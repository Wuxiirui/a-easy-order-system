package wxr;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class DishApp {
    static ArrayList<Dish> dishlist=new ArrayList<>();
    static ArrayList<Dish> personlist=new ArrayList<>();
    public static void main(String[] args) {
        init();
        Scanner s=new Scanner(System.in);
        while(true){
            showmenu();
           int num=s.nextInt();
           switch (num){
               case 1:
                   while(true){
                   showDishmune();
                   int id=s.nextInt();
                   if(id==0){
                       break;
                   }
                   Dish dish1=dishlist.get(id-1);
                       System.out.println("您点了"+dish1.name);
                   personlist.add(dish1);
                   }
               case 2:
                   showPersonmune();
                   break;
               case 3:
                   buy();
                   return;
           }
        }

    }

    public static void showDishmune(){
        System.out.println("--请点菜--");
        for (int i = 0; i < dishlist.size(); i++) {
            Dish dish=dishlist.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("--按0返回上一级--");
    }

    public static void showPersonmune(){
        System.out.println("--已点菜品--");
        for (Dish dish : personlist) {
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }

    }

    public static void buy(){
        System.out.println("--请稍等，正在结算--");
        double total=0;
        for (Dish dish : personlist) {
            total+= dish.price;
        }
        System.out.println(total);
    }
    public static void showmenu(){
        System.out.println("--主菜单--");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已点菜品\t\t 2");
        System.out.println("买单\t\t\t  3");

    }
    public static void init(){
        Dish d1=new Dish(1,"鱼香肉丝",30);
        dishlist.add(d1);
        dishlist.add(new Dish(2,"地三鲜", 18));
        dishlist.add(new Dish(3,"家常凉菜", 19));
    }

}
