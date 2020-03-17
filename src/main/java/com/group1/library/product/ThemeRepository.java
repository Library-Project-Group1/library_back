package com.group1.library.product;

import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme,Long> {

    Theme getThemeByThemeName(String themeName);
}
