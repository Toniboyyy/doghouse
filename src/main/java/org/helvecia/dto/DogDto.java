package org.helvecia.dto;

import java.util.Date;

import org.helvecia.entities.enumerations.Gender;
import org.helvecia.utils.ValidationGroups.Create;
import org.helvecia.utils.ValidationGroups.Update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class DogDto {
    
    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank(groups = Create.class)
    private String name;

    @NotNull(groups = Create.class)
    private Gender gender;

    @NotNull(groups = Create.class)
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
