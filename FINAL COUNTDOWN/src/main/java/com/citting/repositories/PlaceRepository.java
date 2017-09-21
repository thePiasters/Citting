package com.citting.repositories;

import com.citting.entity.Category;
import com.citting.entity.Place;
import com.citting.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PlaceRepository extends JpaRepository<Place, Long> {


    List<Place> findAllByCategory (Category category);
    List<Place> findAll ();
    void deleteAllByCategory(Category category);
}
