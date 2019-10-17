package com.simbirsoft.homework.constants;

import com.simbirsoft.homework.model.Role;

@Deprecated
public abstract class RoleConstants {

    public final static Role ROLE_USER = new Role(1L, "USER");
    public final static Role ROLE_ADMIN = new Role(2L, "ADMIN");

}
