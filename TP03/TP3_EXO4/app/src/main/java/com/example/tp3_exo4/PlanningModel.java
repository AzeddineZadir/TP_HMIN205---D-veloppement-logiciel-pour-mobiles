package com.example.tp3_exo4;

import androidx.lifecycle.ViewModel;


public class PlanningModel  extends ViewModel {
    private String p1=" 08h-10h : Rencontre client Dupont";
    private String p2 ="10h-12h : Travailler le dossier recrutement";
    private String  p3 = "14h-16h : Réunion équipe" ;
    private String  p4 = "16h-18h : Préparation dossier vente.";








    public String getP1 (){
        return this.p1 ;
    }
    public String getP2 (){
        return this.p2 ;
    }
    public String getP3 (){
        return this.p3 ;
    }
    public String getP4 (){
        return this.p4 ;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
