package interfaces.named;

import java.util.Comparator;

/**
 * Created by sklirg on 2/23/14.
 *
 * Comparator for Person1 and Person2 classes.
 *
 */
public class NamedComparator implements Comparator<INamed> {

/*
    public NamedComparator() {

    }*/

    public int compare(INamed name1, INamed name2) {
        int diffFamilyName = name1.getFamilyName().compareTo(name2.getFamilyName());
        int diffGivenName = name1.getGivenName().compareTo(name2.getGivenName());
        if (diffFamilyName != 0)
            return diffFamilyName;
        else if (diffGivenName != 0)
            return name1.getGivenName().compareTo(name2.getGivenName());
        else
            return 0;
    }

}
