package com.example.tugas4;

import java.util.ArrayList;

public class UnivData {
    private static String[] title = new String[]{
            "UPN","UGM","UII","UNY","UAD","UMM"
    };

    private static int[] thumbnail = new int[]{
            R.drawable.upn,R.drawable.ugm,R.drawable.uii,R.drawable.uny,R.drawable.uad, R.drawable.umm
    };

    private static String[] preview = new String[]{
            "Universitas Pembangunan Nasional 'Veteran' Yogyakarta",
            "Universitas Gadjah Mada",
            "Universitas Islam Indonesia",
            "Universitas Negeri Yogyakarta",
            "Universitas Ahmad Dahlan",
            "Universitas Muhammadiyah Yogyakarta"
            };

    public static ArrayList<UnivModel> getListData(){
        UnivModel univModel = null;
        ArrayList<UnivModel> list = new ArrayList<>();
        for (int i=0; i<title.length; i++){
            univModel = new UnivModel();
            univModel.setPhoto(thumbnail[i]);
            univModel.setPlayer_name(title[i]);
            univModel.setPreview(preview[i]);

            list.add(univModel);
        }return list;
    }
}