package com.example.jd.s14;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.jd.s14.dao.Region;
import com.example.jd.s14.dao.RegionDao;

public class RegionMain {
    private static final Logger log = LogManager.getLogger(RegionMain.class);

    public static void main(String[] args) {
        RegionDao rd = new RegionDao();

        final long id = 501L;
        rd.save(new Region(id, "Oceania"));

        Region fiveOone = rd.legacyGet(id);
        if (fiveOone == null) {
            log.error("Unexpected! Can't get the region " + id);
            System.out.println("Region has not been saved correctly!");
            return;
        } else {
            System.out.println("Get: " + fiveOone);
        }

        fiveOone.setName("Ocean");
        rd.update(fiveOone);
        System.out.println("Update renamed: " + fiveOone);

        rd.delete(id);

        fiveOone = rd.legacyGet(id);
        if (fiveOone == null) {
            System.out.println("Region correctly removed");
        } else {
            System.out.println("Unexpected! Region is still alive: " + fiveOone);
        }

        System.out.println("All coders");
        List<Region> regions = rd.getAll();
        for (Region region : regions) {
            System.out.println(region);
        }
    }
}
