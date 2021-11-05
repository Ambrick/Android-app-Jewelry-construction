package com.example.jewelryConstructionProject;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class JewelryStorage {

    private static JewelryStorage jewelryStorageInstance;

    private final List<String> listWithJewelryBasics = Arrays.asList(
            "Подвеска", "Сережка", "Сережки", "Браслет", "Кольцо", "Кулон"
    );
    private final List<String> listWithJewelryGems = Arrays.asList(
            "Алмаз", "Топаз", "Нефрит", "Аметист", "Изумруд", "Гранат"
    );

    private Context appContext;

    ArrayList<Jewelry> jewelryList = new ArrayList<>();
    int listSize = 50;

    public JewelryStorage(Context appContext){
        this.appContext = appContext;
        GenerateNewJewelryList();
    }

    public void GenerateNewJewelryList(){
        jewelryList.clear();
        for (int i = 0; i < listSize; i++)
        {
            //Generating a title for jewelry
            String title = "Jewelry " + (i + 1);
            //Generating components description
            int indexOfJewelryBasic = new Random().nextInt(listWithJewelryBasics.size() - 1);
            String jewelryBasic = listWithJewelryBasics.get(indexOfJewelryBasic) + " + ";
            int indexOfJewelryGem = new Random().nextInt(listWithJewelryGems.size() - 1);
            int GemCountInJewelry = new Random().nextInt(9) + 1;
            String JewelryGems= listWithJewelryGems.get(indexOfJewelryGem) + " (" + GemCountInJewelry + "шт.)";
            String finalJewelryComponentsDescription = jewelryBasic + JewelryGems;
            //Generating jewelry creation date
            String dateOfCreation = RandomDateGenerator.generateDate();
            //Generating exhibition status
            Boolean isForExhibition = new Random().nextBoolean();

            jewelryList.add(new Jewelry(title, finalJewelryComponentsDescription, dateOfCreation, isForExhibition));
        }
    }

    public ArrayList<Jewelry> getJewelryList() {
        return jewelryList;
    }

    public Jewelry getJewelryById(UUID id) {
        for (Jewelry jewelry : jewelryList) {
            if (jewelry.getId().equals(id))
                return jewelry;
        }
        return null;
    }

    public static JewelryStorage get(Context aContext) {

        if (jewelryStorageInstance == null) {
            jewelryStorageInstance = new JewelryStorage(aContext.getApplicationContext());
        }
        return jewelryStorageInstance;
    }
}
