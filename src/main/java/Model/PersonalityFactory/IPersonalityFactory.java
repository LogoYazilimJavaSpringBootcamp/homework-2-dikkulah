package Model.PersonalityFactory;


import java.util.Date;

public interface IPersonalityFactory {
    IPersonality producePersonality(PersonalityType type, String name, String surName, Date joinDate, String sector);

    IPersonality producePersonality(PersonalityType type, String name, String surName, String sector);
}
