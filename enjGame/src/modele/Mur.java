package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Mur implements Iterable<Case>{
    private ArrayList<Case> mur;

    public Mur() {
        this.mur = new ArrayList<Case>();
    }

    public void ajouterCase(Case toadd){
        mur.add(toadd);
    }

    @Override
    public Iterator<Case> iterator() {
        return mur.iterator();
    }
}
