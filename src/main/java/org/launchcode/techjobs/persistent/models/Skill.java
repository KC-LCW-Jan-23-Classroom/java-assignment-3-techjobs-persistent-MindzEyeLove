package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {
   @NotBlank
    @Size(min = 1, max = 300, message = "Description should be between 1 and 300 characters.")
    public String description;

    @ManyToMany(mappedBy="skills")
    @JoinColumn(name = "job_id")
    private List<Job> jobs = new ArrayList<>();

    public Skill(){
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}