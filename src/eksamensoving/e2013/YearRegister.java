package eksamensoving.e2013;

import java.util.*;

public class YearRegister {
    private Collection<TaxEntity> entities;

    public final int year;

    public YearRegister(int year) {
        this.year = year;
        this.entities= new HashSet<TaxEntity>();
    }

    public String toString() {
        return String.format("YearRegister %s: %s TaxEntities. Max tax is %s, Min tax is %s, Average tax is %s", year, entities.size(), maxTax, minTax, avgTax); // fix
    }

    public boolean containsTaxEntity(String id) {
        for (TaxEntity te : this.entities) {
            if (te.getId().equals(id)) return true;
        }
        return false;
    }

    public boolean addTaxEntity (TaxEntity p) {
        if (this.entities.contains(p)) return false;

        this.entities.add(p);
        return true;
    }

    public boolean removeTaxEntity (TaxEntity p) {
        if (! this.entities.contains(p)) return false;

        this.entities.remove(p);
        return true;
    }

    public Collection<TaxEntity> getTaxEntitiesInCommune(String name) {
        HashSet<TaxEntity> communeentities = new HashSet<TaxEntity>();

        for (TaxEntity te : this.entities) {
            if (te.getCommune().equals(name)) communeentities.add(te);
        }
        return communeentities;
    }
}
