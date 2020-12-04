package com.lambdaschool.piggybank.repositories;

// ----- Auto Imports -----
import com.lambdaschool.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{

}
