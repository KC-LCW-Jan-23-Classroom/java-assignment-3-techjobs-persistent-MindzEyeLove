package org.launchcode.techjobs.persistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Employer extends AbstractEntity {
 @NotBlank
 @Size(min = 1, max = 50, message = "Location should be between 1 and 50 characters.")
private String location;

 public Employer() {
 }

 public String getLocation() {
  return location;
 }

 public void setLocation(String location) {
  this.location = location;
 }
}
