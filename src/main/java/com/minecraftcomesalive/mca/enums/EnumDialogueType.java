package com.minecraftcomesalive.mca.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public enum EnumDialogueType {
    UNASSIGNED(-1, "unassigned"),
    CHILDP(0, "childp"),
    CHILD(1, "child"),
    ADULT(2, "adult"),
    SPOUSE(3, "spouse");

    @Getter private int id;
    @Getter private String name;

    EnumDialogueType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EnumDialogueType byId(int idIn) {
        Optional<EnumDialogueType> state = Arrays.stream(values()).filter((e) -> e.id == idIn).findFirst();
        return state.orElse(UNASSIGNED);
    }

	int getId(int id) {
		// TODO Auto-generated method stub
		return id;
	}
}
