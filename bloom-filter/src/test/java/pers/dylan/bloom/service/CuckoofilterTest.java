package pers.dylan.bloom.service;

import com.github.mgunlogson.cuckoofilter4j.CuckooFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuckoofilterTest {

    // create
    CuckooFilter<Integer> cuckooFilter
            = new CuckooFilter.Builder<Integer>(Funnels.integerFunnel(),2000000).build();

    @BeforeEach
    public void init() {
        for (int i=1;i<10000;i++) {
            cuckooFilter.put(i);
        }
    }

    @Test
    public void cuckooFilterTest() {


        // insert
//        if (cuckooFilter.put(42)) {
//            System.out.println("Insert Success!");
//        }

        // contains
        if (cuckooFilter.mightContain(42)) {
            System.out.println("Found 42");
        }

        // count
        System.out.println("Filte has " + cuckooFilter.getCount() + " items");

        // % loaded
        System.out.println("Filter is " + String.format("%.0f%%", cuckooFilter.getLoadFactor() * 100) + " loaded");

        // delete
        if (cuckooFilter.delete(42)) {
            System.out.println("Delete success!");
        }
    }
}
