package org.helvecia.dto;

import java.time.LocalDate;

import org.helvecia.entities.enumerations.Gender;
import org.helvecia.utils.annotations.BirthRange;
import org.helvecia.utils.annotations.ValidationGroups.Create;
import org.helvecia.utils.annotations.ValidationGroups.Update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public class DogDto {
    
    @Null(groups = Create.class)
    @NotNull(groups = Update.class)
    private Long id;

    @NotBlank(groups = Create.class)
    @Size(min = 3, max = 50)
    private String name;

    @NotNull(groups = Create.class)
    private Gender gender;

    @NotNull(groups = Create.class)
    @BirthRange(min = 0, max = 30, groups = {Create.class, Update.class})
    private LocalDate date;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
