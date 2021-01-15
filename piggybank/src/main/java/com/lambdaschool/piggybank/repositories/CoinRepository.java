package com.lambdaschool.piggybank.repositories;

// ----- Auto Imports -----
import com.lambdaschool.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

// What is happening here is that the CoinRepository interface is extending the CrudRepository abstract class.
// this allows the interface to have access to all of the Crud methods encapsulated in the CrudRepo class.
public interface CoinRepository extends CrudRepository<Coin, Long>
{

}
