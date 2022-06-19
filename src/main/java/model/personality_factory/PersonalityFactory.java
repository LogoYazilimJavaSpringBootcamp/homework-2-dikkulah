package model.personality_factory;



import java.util.Date;

public class PersonalityFactory implements IPersonalityFactory {


    @Override
    public IPersonality producePersonality(PersonalityType type, String name ,String surName, Date joinDate, String sector) {
        return switch (type) {
            case CORPORATE -> new Corporate(name, joinDate,sector);
            case INDIVUDIAL -> new Indivudial(name,surName, joinDate,sector);
        };
    }

    @Override
    public IPersonality producePersonality(PersonalityType type, String name,String surName, String sector) {
        return switch (type) {
            case CORPORATE -> new Corporate(name, sector);
            case INDIVUDIAL -> new Indivudial(name,surName, sector);
        };
    }
}
