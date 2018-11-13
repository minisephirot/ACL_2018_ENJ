package modele.elements;

import modele.elements.Case;

import java.util.ArrayList;
import java.util.Iterator;

public class Mur implements Iterable<Brique>{
    private ArrayList<Brique> mur;

    public Mur() {
        this.mur = new ArrayList<Brique>();
    }

    public void ajouterBrique(Brique toadd){
        mur.add(toadd);
    }

    @Override
    public Iterator<Brique> iterator() {
        return mur.iterator();
    }
}
