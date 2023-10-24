package edu.analytics.rop.services;

import edu.analytics.rop.entities.Run;
import edu.analytics.rop.entities.Section;
import edu.analytics.rop.entities.Well;
import edu.analytics.rop.repository.BitRepository;
import edu.analytics.rop.repository.RunRepository;
import edu.analytics.rop.repository.SectionRepository;
import edu.analytics.rop.repository.WellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WellServiceGet {

    @Autowired
    private WellRepository wellRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private RunRepository runRepository;
    @Autowired
    private BitRepository bitRepository;

    @Transactional
    public List<Well> getWells() {
        return wellRepository.findAll();
    }

    @Transactional
    public List<Section> getSections(int id) {
        return sectionRepository.findAll().stream()
                .filter(s -> s.getWell().getWellId() == id).toList();
    }

    @Transactional
    public List<Run> getRuns(int id) {
        return runRepository.findAll().stream()
                .filter(r -> r.getSection().getSectionId() == id).toList();
    }
}
