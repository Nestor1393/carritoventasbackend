package com.ventas.repository;

import com.ventas.entities.Person;
import com.ventas.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select id_person from usuario where user_name = :user_name and password = :password", nativeQuery = true)
    Optional<Long> encontrarPersonaPorUsuario(@Param("user_name") String user_name, @Param("password") String password);

    @Query(value = "select state.*, city.*, address.*, person.*, usuario.*  \n" +
            "from state join city on state.id_state = city.id_state  join address on city.id_city = address.id_city\n" +
            "join person on address.id_address = person.id_address join usuario on person.id_person = usuario.id_person;", nativeQuery = true)
    List<Object[]> consultarUsuariosCompletos();

    @Query(value = "select usuario.id_user from address join person on address.id_address = person.id_address " +
            "join usuario on person.id_person = usuario.id_person  where address.id_address = :id_address ;", nativeQuery = true)
    Optional<Long> encontrarUsuarioPorDireccion(@Param("id_address") Long id_address);

    @Query(value = "select state.*, city.*, address.*, person.*, usuario.*  \n" +
            "   from state join city on state.id_state = city.id_state  join address on city.id_city = address.id_city\n" +
            "   join person on address.id_address = person.id_address join usuario on person.id_person = usuario.id_person\n" +
            "   where usuario.id_user = :idUsuario ;", nativeQuery = true)
    List<Object[]> consultarUsuarioCompleto(@Param("idUsuario") Long idUsuario);

    @Query(value = "select state.*, city.*, address.*, person.*, customer.* \n" +
            "from state join city on state.id_state = city.id_state  join address on city.id_city = address.id_city\n" +
            "join person on address.id_address = person.id_address join customer on person.id_person = customer.id_person\n" +
            "where customer.id_customer = :idUsuario ;", nativeQuery = true)
    List<Object[]> consultarClienteCompleto(@Param("idUsuario") Long idUsuario);

   @Query(value = "select usuario.id_user from usuario where id_person = :idPerson ;", nativeQuery = true)
    Optional<Long> consultarUsuarioPorIdPersona(@Param("idPerson") Long idPersona);

    @Query(value = "WITH ranked_sales AS (SELECT CONCAT(person.first_name, ' ', person.last_name) AS nombre_completo,\n" +
            "COUNT(orden.id_order) AS ventas, DENSE_RANK() OVER (ORDER BY COUNT(orden.id_order) DESC) AS rank_venta\n" +
            "FROM carrito_ventas.orden JOIN usuario ON orden.id_user = usuario.id_user JOIN person ON person.id_person = usuario.id_person\n" +
            "GROUP BY orden.id_user order by COUNT(orden.id_order) desc)\n" +
            "SELECT nombre_completo, ventas FROM ranked_sales WHERE rank_venta <= 5 ;", nativeQuery = true)
    List<Object[]> consultarUsuariosConMasVentas();

}
