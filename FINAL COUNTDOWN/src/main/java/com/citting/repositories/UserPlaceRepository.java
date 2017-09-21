package com.citting.repositories;

import com.citting.entity.Place;
import com.citting.entity.User;
import com.citting.entity.UserPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserPlaceRepository extends JpaRepository<UserPlace, Long>
{
    List<UserPlace> findAllByUserAndHistoryIsTrue(User user);
    List<UserPlace> findAllByUserAndWishListIsTrue(User user);
    UserPlace findFirstByUserAndPlaceAndAndWishListIsTrue(User user, Place place);
    UserPlace findFirstAllByUserAndPlaceAndHistoryIsTrue(User user,Place place);
    List<UserPlace> deleteAllByUser(User user);
    UserPlace findById(Long id);

    void deleteById(Long id);

    List <UserPlace> findAllByPlace(Place place);
    List <UserPlace> findAllByUser(User user);

    UserPlace findFirstByUserAndPlace(User user, Place place);









}
