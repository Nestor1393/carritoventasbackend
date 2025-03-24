package com.ventas.controllers;


import com.ventas.DTO.MesDTO;
import com.ventas.Service.IOrderDetailService;
import com.ventas.Service.IOrderService;
import com.ventas.Service.IProductService;
import com.ventas.Service.IUserService;
import com.ventas.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@RestController
public class OrderRestController {

    @Autowired
    IOrderService iOrderService;

    @Autowired
    IOrderDetailService iOrderDetailService;

    @Autowired
    IProductService iProductService;

    @Autowired
    IUserService iUserService;


    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/encontrar/ventas/mes")
    public List<Object[]> encontrarVentasPorMes() {
        List<Object[]> meses = new ArrayList<Object[]>();

        meses.add(new Object[]{"Enero", 0});
        meses.add(new Object[]{"Febrero", 0});
        meses.add(new Object[]{"Marzo", 0});
        meses.add(new Object[]{"Abril", 0});
        meses.add(new Object[]{"Mayo", 0});
        meses.add(new Object[]{"Junio", 0});
        meses.add(new Object[]{"Julio", 0});
        meses.add(new Object[]{"Agosto", 0});
        meses.add(new Object[]{"Septiembre", 0});
        meses.add(new Object[]{"Octubre", 0});
        meses.add(new Object[]{"Noviembre", 0});
        meses.add(new Object[]{"Diciembre", 0});

        List<Object[]> lista = iOrderService.encontrarVentasPorMes();

        for (Object[] registro : lista) {

            if (Integer.parseInt(registro[0] + "") == 1) {
                meses.get(0)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 2) {
                meses.get(1)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 3) {
                meses.get(2)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 4) {
                meses.get(3)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 5) {
                meses.get(4)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 6) {
                meses.get(5)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 7) {
                meses.get(6)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 8) {
                meses.get(7)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 9) {
                meses.get(8)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 10) {
                meses.get(9)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 11) {
                meses.get(10)[1] = registro[1];
            } else if (Integer.parseInt(registro[0] + "") == 12) {
                meses.get(11)[1] = registro[1];
            }
        }

        return meses;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/consultar/productos/mes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Object[]> encontrarProductosVendidosPorMes(@RequestBody Map<String, Object> body) {

        Integer idMes = (Integer) body.get("idMes");

        List<Object[]> producto_cantidad = iOrderService.encontrarProductosVendidosPorMes(idMes);
        List<Object[]> topCantidad = iOrderService.encontrarTopTresProductosMasVendidosPorMes(idMes);

        List<Object[]> topTresProductos = new ArrayList<>();

        for (Object[] registro : producto_cantidad) {
            for (Object[] registro2 : topCantidad) {
                if (Integer.parseInt(registro[1] + "") == Integer.parseInt(registro2[0] + "")) {

                    topTresProductos.add(new Object[]{registro[0], registro[1]});
                }
            }
        }

        return topTresProductos;
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/consultar/producto/uno/mes", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<MesDTO> encontrarProductoMasVendidoPorMes() {

        List<MesDTO> listaMesProductoCantidad = new ArrayList<>();

        for (int i = 1; i <= 12; i++) {
            List<Object[]> producto_cantidad = iOrderService.encontrarProductoMasVendidoPorMes(i);
            MesDTO mes = new MesDTO();
            String nombre_mes = "";

            if (i == 1) {
                nombre_mes = "Enero";
            } else if (i == 2) {
                nombre_mes = "Febrero";
            } else if (i == 3) {
                nombre_mes = "Marzo";
            } else if (i == 4) {
                nombre_mes = "Abril";
            } else if (i == 5) {
                nombre_mes = "Mayo";
            } else if (i == 6) {
                nombre_mes = "Junio";
            } else if (i == 7) {
                nombre_mes = "Julio";
            } else if (i == 8) {
                nombre_mes = "Agosto";
            } else if (i == 9) {
                nombre_mes = "Septiembre";
            } else if (i == 10) {
                nombre_mes = "Octubre";
            } else if (i == 11) {
                nombre_mes = "Noviembre";
            } else if (i == 12) {
                nombre_mes = "Diciembre";
            }

            if (producto_cantidad.size() > 0) {

                Object[] prod_cantidad = producto_cantidad.get(0);
                // System.out.println("Mes: "+nombre_mes+" Producto: "+prod_cantidad[0]+" Cantidad: "+prod_cantidad[1]);
                mes.setMonth(nombre_mes);
                mes.setQuantity(Integer.parseInt(prod_cantidad[1] + ""));
                mes.setProductName(prod_cantidad[0] + "");

            } else {

                mes.setMonth(nombre_mes);
                mes.setQuantity(0);
                mes.setProductName("");
                //System.out.println("El mes "+nombre_mes+"  no cuenta con productos");

            }
            listaMesProductoCantidad.add(mes);
        }

        for (MesDTO mes : listaMesProductoCantidad) {
            System.out.println("Month: " + mes.getMonth() + " Quantity: " + mes.getQuantity() + " ProductName: " + mes.getProductName());
        }

        return listaMesProductoCantidad;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/consultar/folio/actual")
    public ResponseEntity<String> encontrarFolioActual() {

        String folio = (String) iOrderService.encontrarFolioActual()[0];

        return ResponseEntity.ok(folio);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/consultar/ventas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> consultarVentas(@RequestBody Map<String, Object> body) {

        String fechaInicio = (String) body.get("fechaInicio");
        String fechaFin = (String) body.get("fechaFin");

        List<Object[]> ventas = iOrderService.encontrarOrderPorFecha(fechaInicio, fechaFin);

        return ResponseEntity.ok(ventas);
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/consultar/venta/detalle", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Object[]>> consultarVentaDetalle(@RequestBody Integer idVenta) {

        List<Object[]> ventaDetalle = iOrderService.encontrarDetalleVenta(idVenta);

        return ResponseEntity.ok(ventaDetalle);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @RequestMapping(value = "/guardar/venta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> guardarVenta(@RequestBody Map<String, Object> body) {

        Map<String, Object> respuesta = new HashMap<String, Object>();

        String folio = encontrarFolioActual().getBody();

        //================================================
        String subtotal = (String) body.get("subtotal");
        String total = (String) body.get("total");
        String cliente = (String) body.get("cliente");
        String usuario = (String) body.get("usuario");
        String codigobarras = (String) body.get("codigobarras");


        Order orden = new Order();

        Customer clienteObject = new Customer();
        clienteObject.setId_customer(Long.parseLong(cliente));

        Optional<Long> usuarioEncontrado = iUserService.consultarUsuarioPorIdPersona(Long.parseLong(usuario));
        Long user = null;
        if(usuarioEncontrado.isPresent()){
            user = usuarioEncontrado.get();
        }

        User usuarioObject = new User();
        //usuarioObject.setId_user(Long.valueOf((String) usuarioEncontrado[0]));
        usuarioObject.setId_user(user);
        orden.setSubtotal(Double.parseDouble(subtotal));
        orden.setTotal(Double.parseDouble(total));
        orden.setBarcode(Long.parseLong(codigobarras));
        orden.setId_customer(clienteObject);
        orden.setId_user(usuarioObject);
        orden.setOrder_date(LocalDateTime.of(LocalDate.now(), LocalTime.now()));

        Order ordenGuardada = iOrderService.guardarOrder(orden);

        int cantidadProductos = 0;
        List<Map<String, Object>> productos = null;

        if (ordenGuardada != null) {


            cantidadProductos = 0;

            productos = (List<Map<String, Object>>) body.get("productos");
            for (Map<String, Object> producto : productos) {

                Map<String, Object> productoMap = (Map<String, Object>) producto.get("producto");

                String idProducto = productoMap.get("value").toString();

                String totalProducto = producto.get("total") + "".toString();
                String cantidad = producto.get("cantidad") + "".toString();

                OrderDetail detalleVenta = new OrderDetail();

                Product productoId = new Product();
                productoId.setId_product(Long.parseLong(idProducto));

                detalleVenta.setId_product(productoId);
                detalleVenta.setCantidad(Integer.parseInt(cantidad));
                detalleVenta.setCosto(Double.parseDouble(totalProducto));
                detalleVenta.setId_order(ordenGuardada);

                OrderDetail ventaGuardada = iOrderDetailService.guardarOrderDetail(detalleVenta);

                if (ventaGuardada != null) {

                    iProductService.actualizarStockProducto(Integer.parseInt(cantidad), Long.parseLong(idProducto));

                    cantidadProductos += 1;
                }
            }
        }

        if (cantidadProductos == productos.size()) {

            respuesta.put("mensaje", "La venta con el folio: " + folio + " se registró correctamente");
            respuesta.put("folio", encontrarFolioActual().getBody());
        }

        return ResponseEntity.ok(respuesta);
    }
}