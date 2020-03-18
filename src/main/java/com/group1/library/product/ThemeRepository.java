package com.group1.library.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {

    Theme getThemeByName(String name);
}
