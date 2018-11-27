package modele.elements;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The type Mur.
 */
public class Mur implements Iterable<Brique>{
    private ArrayList<Brique> mur;

    /**
     * Instantiates a new Mur.
     */
    public Mur() {
        this.mur = new ArrayList<Brique>();
    }

    /**
     * Ajouter brique.
     *
     * @param toadd the toadd
     */
    public void ajouterBrique(Brique toadd){
        mur.add(toadd);
    }

    /**
     * Tout casser.
     */
    public void toutCasser(){ mur.clear();}

    @Override
    public Iterator<Brique> iterator() {
        return mur.iterator();
    }
}
