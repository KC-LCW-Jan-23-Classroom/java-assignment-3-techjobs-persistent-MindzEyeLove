package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {
 @NotBlank
 @Size(min = 1, max = 50, message = "Location should be between 1 and 50 characters.")
private String location;

 public Employer() {
 }

@OneToMany
@JoinColumn(name = "employer_id")
 private List<Job> jobs = new ArrayList<>();



 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }
}
