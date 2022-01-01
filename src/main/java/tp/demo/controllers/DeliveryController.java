package tp.demo.controllers;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tp.demo.Entities.Delivery;
import tp.demo.Repositories.DeliveryRepository;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;

@RestController
@CrossOrigin("*")

public class DeliveryController {
    @Autowired
    DeliveryRepository deliveryRepository;
    @GetMapping("/LivreurRapide")
    public String  GetLivreurRapide() {
        List<Delivery> delivery = deliveryRepository.findAll();
        HashMap<String,ArrayList<Integer>> names = new HashMap<>();
        for (Delivery i : delivery) {
            if (!names.containsKey(i.getDelivery_man())) {
                ArrayList<Integer> id =new ArrayList<>();
                id.clear();
                id.add(i.getId());
                names.put(i.getDelivery_man(),id);
            }
            else {
                ArrayList<Integer> id =new ArrayList<>();
                id.clear();
                id=names.get(i.getDelivery_man());
                id.add(i.getId());
                names.put(i.getDelivery_man(),id);

            }
        }
        long som=0;
        long moy=0;
        long max=0;
        String name = "";
        String n = "";
        ArrayList<Date> a = new ArrayList<Date>();
        ArrayList<Date> b = new ArrayList<Date>();
        for (ArrayList<Integer>i : names.values()) {
            System.out.println(i);
            som=0;
            moy=0;
            for (Integer j : i){
                Optional<Delivery> deliveriesByname = deliveryRepository.findById(j);

                for (Delivery k : delivery) {
                    n=k.getDelivery_man();
                    LocalDate dat =LocalDate.parse(k.getShoppingDate().toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate datt =LocalDate.parse(k.getDeliveryDate().toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration du = Duration.between(dat.atStartOfDay(), datt.atStartOfDay());
                    som+=du.toDays();
                }
            }moy=som/i.size();
            if (moy>max){max=moy;name=n;}

        }  System.out.println("le livreur qui a une moyenne de temps de livraison la plus rapide est:"+name);



        /*long max=0;
        Integer j=0;
        String name = "";
        ArrayList<Date> a = new ArrayList<Date>();
        ArrayList<Date> b = new ArrayList<Date>();
        for (Delivery i : delivery){
            a.add(i.getShoppingDate());
            b.add(i.getDeliveryDate());
            LocalDate dat =LocalDate.parse(a.get(0).toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate datt =LocalDate.parse(b.get(0).toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
            Duration du = Duration.between(dat.atStartOfDay(), datt.atStartOfDay());
            if (max<du.toDays()){
                max = du.toDays();
                name=i.getDelivery_man();
            }
            j+=1;
        }
        System.out.println("le livreur qui a une moyenne de temps de livraison la plus rapide est:"+name);
        */










        /*for (int j = 0; j < a.size(); j++) {
            LocalDate dat = LocalDate.parse(a.get(j).toString().substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate datt = LocalDate.parse(b.get(j).toString().substring(0, 10), DateTimeFormatter.ISO_LOCAL_DATE);
            //System.out.println(Duration.between(dat.atStartOfDay(), datt.atStartOfDay()).toDays());
            Duration du = Duration.between(dat.atStartOfDay(), datt.atStartOfDay());
            if (max<du.toDays()){
                max = du.toDays();
                name=c.get(j);
            }

            System.out.println(name);
            System.out.println(max);
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        delivery.stream()
                .filter(d ->d.getDelivery_man().equals("souhail" ))
                .forEach (d->System.out.println(d));

        Delivery delivery1=new Delivery();
        delivery1.setDelivery_man("souhail");
        delivery1.setDeliveryDate(date);
        delivery1.setShoppingDate(date);
        deliveryRepository.save(delivery1);
        // List<Delivery> deliveries= deliveryRepository.findAll();
        System.out.println(delivery);
        System.out.println("hellll");*/

        return "le livreur qui a une moyenne de temps de livraison la plus rapide est:"+name;
    }
    @GetMapping("/LivreurLent")
    public String  GetLivreurLent() {
        List<Delivery> delivery = deliveryRepository.findAll();
        HashMap<String,ArrayList<Integer>> names = new HashMap<>();
        for (Delivery i : delivery) {
            if (!names.containsKey(i.getDelivery_man())) {
                ArrayList<Integer> id =new ArrayList<>();
                id.clear();
                id.add(i.getId());
                names.put(i.getDelivery_man(),id);
            }
            else {
                ArrayList<Integer> id =new ArrayList<>();
                id.clear();
                id=names.get(i.getDelivery_man());
                id.add(i.getId());
                names.put(i.getDelivery_man(),id);

            }
        }
        long som=0;
        long moy=0;
        long min=11111;
        String name = "";
        String n = "";
        ArrayList<Date> a = new ArrayList<Date>();
        ArrayList<Date> b = new ArrayList<Date>();
        for (ArrayList<Integer>i : names.values()) {
            som=0;
            moy=0;
            for (Integer j : i){
                Optional<Delivery> deliveriesByname = deliveryRepository.findById(j);

                for (Delivery k : delivery) {
                    n=k.getDelivery_man();
                    LocalDate dat =LocalDate.parse(k.getShoppingDate().toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
                    LocalDate datt =LocalDate.parse(k.getDeliveryDate().toString().substring(0,10), DateTimeFormatter.ISO_LOCAL_DATE);
                    Duration du = Duration.between(dat.atStartOfDay(), datt.atStartOfDay());
                    som+=du.toDays();                }
            }moy=som/i.size();

            if (moy<min){min=moy;name=n;}

        }  System.out.println("le livreur qui a une moyenne de temps de livraison la plus lente est:"+name);




        return "le livreur qui a une moyenne de temps de livraison la plus lente est:"+name;
    }

}
