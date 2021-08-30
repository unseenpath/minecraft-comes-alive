package com.minecraftcomesalive.mca.api.objects;

import com.minecraftcomesalive.mca.enums.EnumGender;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class SkinsGroup {
    private final String gender = "";
    private final String profession = "";
    @Getter private final String[] paths;

    public EnumGender getGender() {
        return EnumGender.byName(gender);
    }

	public String[] getPaths() {
		// TODO Auto-generated method stub
		return this.paths;
	}
    

}
