package com.group1.library.repository;

import com.group1.library.entity.Theme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {

    Theme getThemeByName(String name);
}
