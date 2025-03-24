
$(document).ready(function(){

consultarCategorias();
function consultarCategorias(){

    $.get("/consultar/todas/categorias", function(categorias){


        var tableCategorias = $('<table>').addClass('table table-bordered').append('<thead><tr><th>#</th><th>Categoria</th><th>Editar</th><th>Eliminar</th></tr></thead><tfoot><tr><th>#</th><th>Categoria</th><th>Editar</th><th>Eliminar</th></tr></tfoot>')
        var tbody = $('<tbody>');

        $.each(categorias, function(index, categoria){

        var fila = $('<tr>');
            fila.append($('<td>').text(index+1));
            fila.append($('<td>').text(categoria[1]));

        var editButton =  $('<button>').addClass('btn btn-outline-info').on('click', function(){
           mostrarCategoriaEditar(categoria);
        });
        var trashIcon1 = $('<i>').addClass('bi bi-pencil');
            editButton.append(trashIcon1);

        var deleteButton = $('<button>').addClass('btn btn-outline-danger').on('click', function(){

         if(categoria[2] > 0){

            Swal.fire({
                 title: "Categoria asignada a un producto",
                 icon: "info"
                 });
         }else if(categoria[2] == 0){

             Swal.fire({
               title: "¿Estás seguro de eliminar la Categoria?",
               //text: "Una vez eliminado no hay vuelta atras",
               icon: "warning",
               showCancelButton: true,
               confirmButtonColor: "#3085d6",
               cancelButtonColor: "#d33",
               confirmButtonText: "Eliminar"
               //cancelButtonText: "Cancelar"
             }).then((result) => {
               if (result.isConfirmed) {
                 eliminarCategoria(categoria[0]);
               }
             });
         }
        });

        var trashIcon2 = $('<i>').addClass('bi bi-trash');
            deleteButton.append(trashIcon2);

            if(categoria[2] > 0){
                deleteButton.tooltip({
                   title: 'Categoria asignada a un producto',
                   placement: 'right' // Puedes cambiar la posición del tooltip (top, bottom, left, right)
                });
            }

        fila.append($('<td>').addClass('center-cell').append(editButton));
        fila.append($('<td>').addClass('center-cell').append(deleteButton));

        tbody.append(fila);

        });

        tableCategorias.append(tbody);

        $("#divCategorias").empty();
        $("#divCategorias").append(tableCategorias);

        //tableCategorias.DataTable();

        new DataTable(tableCategorias, {
                                language: {
                                    url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
                                },
                            });

    });

}

//===============================================================

function eliminarCategoria(idCategoria) {

    $.ajax({
        url: '/eliminar/categoria',
        type: 'DELETE',
        data: { "idCategoria" : idCategoria },
        success: function (response) {

            var respuesta = response;

            Swal.fire({
               title: respuesta+"",
               icon: "info"
            });

            consultarCategorias();

        },
        error: function (error) {
            alert(response);
        }
    });
}

//==================================================================
 consultarProductos();
//==================================================================
function consultarProductos(){

$.get("/consultar/productos/detalleventa", function (productos) {

 var tableProductos = $('<table>').addClass('table table-bordered').append('<thead><tr><th>#</th><th>Producto</th><th>Código</th><th>Precio</th><th>Editar</th><th>Eliminar</th></tr></thead><tfoot><tr><th>#</th><th>Producto</th><th>Código</th><th>Precio</th><th>Editar</th><th>Eliminar</th></tr></tfoot>');
    var tbody = $('<tbody>');

        $.each(productos, function (index, producto) {
            var fila = $('<tr>');
                fila.append($('<td>').text(index+1));
                fila.append($('<td>').text(producto[4]));
                fila.append($('<td>').text(producto[3]));
                fila.append($('<td>').text(producto[2]));

                var editButton = $('<button>').addClass('btn btn-outline-info').on('click', function(){
                                   mostrarProductoEditar(producto);

                                 });

                                var trashIcon1 = $('<i>').addClass('bi bi-pencil');
                                   editButton.append(trashIcon1);

                    var deleteButton = $('<button>').addClass('btn btn-outline-danger').on('click', function(){

                                        if(producto[8] > 0){

                                                Swal.fire({
                                                 title: "Producto asignado a una venta",
                                                 icon: "info"
                                                 });

                                        }else if(producto[8] == 0){

                                                     Swal.fire({
                                                       title: "¿Estás seguro de eliminar el Producto?",
                                                       //text: "Una vez eliminado no hay vuelta atras",
                                                       icon: "warning",
                                                       showCancelButton: true,
                                                       confirmButtonColor: "#3085d6",
                                                       cancelButtonColor: "#d33",
                                                       confirmButtonText: "Eliminar"
                                                       //cancelButtonText: "Cancelar"
                                                     }).then((result) => {
                                                       if (result.isConfirmed) {
                                                         eliminarProducto(producto[0]);
                                                       }
                                                     });
                                                 }
                                    });

                          if(producto[8] > 0){
                                deleteButton.tooltip({
                                  title: 'Producto asignado a una venta',
                                  placement: 'right' // Puedes cambiar la posición del tooltip (top, bottom, left, right)
                           });
                          }

                var trashIcon2 = $('<i>').addClass('bi bi-trash');
                deleteButton.append(trashIcon2);

                fila.append($('<td>').addClass('center-cell').append(editButton));
                fila.append($('<td>').addClass('center-cell').append(deleteButton));
                tbody.append(fila);
        });

        tableProductos.append(tbody);

        $("#divProductos").empty();
        $("#divProductos").append(tableProductos);

        //tableProductos.DataTable();

        new DataTable(tableProductos, {
                        language: {
                            url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
                        },
                    });

    });

    }

    //==================================================================
     consultarTodosProveedores();
    //==================================================================
    function consultarTodosProveedores(){

    $.get("/consultar/proveedores/completos", function (proveedores) {

     var tableProveedores = $('<table>').addClass('table table-bordered').append('<thead><tr><th>#</th><th>Proveedor</th><th>Editar</th><th>Eliminar</th></tr></thead><tfoot><tr><th>#</th><th>Proveedor</th><th>Editar</th><th>Eliminar</th></tr></tfoot>');
        var tbody = $('<tbody>');

            $.each(proveedores, function (index, proveedor) {
                var fila = $('<tr>');
                    fila.append($('<td>').text(index+1));
                    fila.append($('<td>').text(proveedor[1]));

                    var editButton = $('<button>').addClass('btn btn-outline-info').on('click', function(){
                                       mostrarProveedorEditar(proveedor);

                                     });

                                    var trashIcon1 = $('<i>').addClass('bi bi-pencil');
                                       editButton.append(trashIcon1);

                        var deleteButton = $('<button>').addClass('btn btn-outline-danger').on('click', function(){

                                            if(proveedor[3] > 0){

                                                    Swal.fire({
                                                     title: "Proveedor asingado a un Producto",
                                                     icon: "info"
                                                     });

                                            }else if(proveedor[3] == 0){

                                                         Swal.fire({
                                                           title: "¿Estás seguro de eliminar el Proveedor?",
                                                           //text: "Una vez eliminado no hay vuelta atras",
                                                           icon: "warning",
                                                           showCancelButton: true,
                                                           confirmButtonColor: "#3085d6",
                                                           cancelButtonColor: "#d33",
                                                           confirmButtonText: "Eliminar"
                                                           //cancelButtonText: "Cancelar"
                                                         }).then((result) => {
                                                           if (result.isConfirmed) {
                                                             eliminarProveedor(proveedor[0]);
                                                           }
                                                         });
                                                     }
                                        });

                              if(proveedor[3] > 0){
                                    deleteButton.tooltip({
                                      title: 'Proveedor asingado a un Producto',
                                      placement: 'right' // Puedes cambiar la posición del tooltip (top, bottom, left, right)
                               });
                              }

                    var trashIcon2 = $('<i>').addClass('bi bi-trash');
                    deleteButton.append(trashIcon2);

                    fila.append($('<td>').addClass('center-cell').append(editButton));
                    fila.append($('<td>').addClass('center-cell').append(deleteButton));
                    tbody.append(fila);
            });

            tableProveedores.append(tbody);

            $("#divProveedores").empty();
            $("#divProveedores").append(tableProveedores);

            //tableProveedores.DataTable();

            new DataTable(tableProveedores, {
                language: {
                    url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
                },
            });

        });

        }

 //==============================================================
  function mostrarProveedorEditar(proveedor) {

    $("#idProveedorEdit").val(proveedor[0]);
    $("#nombreProveedorEdit").val(proveedor[1]);
    $("#categoriaProveedorEdit").val(proveedor[2]);

    $('#editarProveedor').modal('show');

  }

 //==============================================================
  function mostrarCategoriaEditar(categoria) {

    $("#idCategoriaEdit").val(categoria[0]);
    $("#nombreCategoriaEdit").val(categoria[1]);
    $('#editarCategoria').modal('show');

  }

  //==============================================================
  function mostrarProductoEditar(producto) {

    $("#idProductoEdit").val(producto[0]);
    $("#nombreProductoEdit").val(producto[4]);
    $("#precioProductoEdit").val(producto[2]);
    $("#stockProductoEdit").val(producto[5]);
    $("#codigoProductoEdit").val(producto[3]);
    $("#categoriaProductoEdit").val(producto[11]);
    $("#descripcionProductoEdit").val(producto[1]);

    consultarProveedores(producto[11], producto[9]);

    $('#editarProducto').modal('show');

  }

  //==============================================================
    $("#editarCategoriaForm").submit(e => {
      e.preventDefault();

      const datosActualizar = {

                id_category: $("#idCategoriaEdit").val(),
                category_name:  $("#nombreCategoriaEdit").val(),

          }

          $.ajax({
              url: "/actualizar/categoria",
              data: datosActualizar,
              type: "POST",
              success: function(response){
                  if(!response.error){

                      var respuesta = response;

                       Swal.fire({
                          title: respuesta+"",
                          icon: "info"
                        });

                      consultarCategorias();
                      consultarProductos();
                      consultarCategoriasSelect();
                      $('#editarCategoria').modal('hide');

                  }
              },
              error: function(error){
                  alert(error);
              }
          })
    })
//==============================================================
     $("#editarProveedorForm").submit(e => {
      e.preventDefault();

      const datosActualizar = {
                //id_supplier: $("#idProveedorEdit").val(),
                supplier_name: $("#nombreProveedorEdit").val(),
                id_category: $("#categoriaProveedorEdit").val()
          }

          $.ajax({
              url: "/actualizar/proveedor/"+($("#idProveedorEdit").val()),
              data: datosActualizar,
              type: "PUT",
              success: function(response){
                  if(!response.error){

                      var respuesta = response;

                       Swal.fire({
                          title: respuesta+"",
                          icon: "info"
                        });

                      consultarProductos();
                      consultarTodosProveedores();
                      consultarCategoriasSelect();
                      $('#editarProveedor').modal('hide');

                  }
              },
              error: function(error){
                  alert("Error: "+error);
              }
          })
    })

  //==============================================================
  $("#editarProductoForm").submit(e => {
    e.preventDefault();

    const datosActualizar = {

              id_product: $("#idProductoEdit").val(),
              product_name:  $("#nombreProductoEdit").val(),
              price:  $("#precioProductoEdit").val(),
              stock:  $("#stockProductoEdit").val(),
              product_code:  $("#codigoProductoEdit").val(),
              description:  $("#descripcionProductoEdit").val(),
              id_supplier:  $("#proveedorProductoEdit").val()
        }

        $.ajax({
            url: "/actualizar/producto",
            data: datosActualizar,
            type: "POST",
            success: function(response){
                if(!response.error){
                    //$("#editarProductoForm").trigger("reset");
                    consultarProductos();
                    $('#editarProducto').modal('hide');

                    Swal.fire({
                        title: response+"",
                        icon: "info"
                    });
                }
            },
            error: function(error){
                alert(error);
            }
        })
  })

  //===============================================================

  function eliminarProveedor(idProveedor) {

      $.ajax({
          url: '/eliminar/proveedor',
          type: 'DELETE',
          data: { "idProveedor" : idProveedor },
          success: function (response) {

              var respuesta = response;

                Swal.fire({
                  title: respuesta+"",
                  icon: "info"
               });

              consultarTodosProveedores();

          },
          error: function (error) {
              alert(response);
          }
      });
  }

  //===============================================================

function eliminarProducto(idProducto) {

    $.ajax({
        url: '/eliminar/producto',
        type: 'DELETE',
        data: { "idProducto" : idProducto },
        success: function (response) {

            var respuesta = response;

              Swal.fire({
                title: respuesta+"",
                icon: "info"
             });

            consultarProductos();
        },

        error: function (error) {
            alert(response);
        }
    });
}


//================================================================================
categoriasProveedoresSelect();

function categoriasProveedoresSelect(){
    $.get("/consultar/categorias", function (data) {
            //populateSelect("#select1", data);
            $("#categoriaProveedorEdit").empty();
            $("#categoriaProveedorEdit").append($('<option>', {
                          text: "Selecciona una categoria...",
                          value: ""
                 }));
            $.each(data, function (index, categoria) {

                 $("#categoriaProveedorEdit").append($("<option>").text(categoria.category_name).val(categoria.id_category));
            });
        });
  }
//================================================================================
consultarCategoriasSelect();

function consultarCategoriasSelect(){
    $.get("/consultar/categorias", function (data) {
            //populateSelect("#select1", data);
            $("#categoriaProductoEdit").empty();
            $("#categoriaProductoEdit").append($('<option>', {
                          text: "Selecciona una categoria...",
                          value: ""
                 }));
            $.each(data, function (index, categoria) {

                 $("#categoriaProductoEdit").append($("<option>").text(categoria.category_name).val(categoria.id_category));
            });
        });
  }

    $("#categoriaProductoEdit").change(function () {
                var idCategoria = $(this).val();

                if(idCategoria === ""){

                            $("#proveedorProductoEdit").empty();
                            $("#proveedorProductoEdit").append($('<option>', {
                                 text: "Selecciona un proveedor...",
                                 value: ""
                              }));
                }else{

                // Obtener y cargar las opciones para el segundo select basado en la selección del primero
                $.get("/consultar/proveedores?idCategoria=" + idCategoria, function (data) {

                    $("#proveedorProductoEdit").empty();
                    $("#proveedorProductoEdit").append($('<option>', {
                                          text: "Selecciona un proveedor...",
                                          value: ""
                                 }));
                            $.each(data, function (index, proveedor) {
                                 $("#proveedorProductoEdit").append($("<option>").text(proveedor[1]).val(proveedor[0]));
                            });
                });

                }
            });

 //===================================================================================

function consultarProveedores(categoriaSeleccionada, proveedorSeleccionado){

    $.get("/consultar/todos/proveedores", function (data) {
            //populateSelect("#select1", data);
            $("#proveedorProductoEdit").empty();
            $("#proveedorProductoEdit").append($('<option>', {
                          text: "Selecciona un proveedor...",
                          value: ""
                 }));

            $.each(data, function (index, proveedor) {

                if(categoriaSeleccionada == proveedor[2]){

                if(proveedorSeleccionado == proveedor[0]){
                    $("#proveedorProductoEdit").append($("<option>").text(proveedor[1]).val(proveedor[0]).prop('selected', true));

                }else{
                   $("#proveedorProductoEdit").append($("<option>").text(proveedor[1]).val(proveedor[0]));
                }
              }
            });

        });
   }
//===================================================================================

 $.get("/consultar/categorias", function (data) {
        //populateSelect("#select1", data);
        $("#categoriaProducto2").empty();
        $("#categoriaProducto2").append($('<option>', {
                      text: "Selecciona una categoria...",
                      value: ""
             }));
        $.each(data, function (index, categoria) {

             $("#categoriaProducto2").append($("<option>").text(categoria.category_name).val(categoria.id_category));
        });
    });

    $("#categoriaProducto2").change(function () {
            var idCategoria = $(this).val();

            if(idCategoria === ""){

            $("#proveedorProducto").empty();
            $("#proveedorProducto").append($('<option>', {
                 text: "Selecciona un proveedor...",
                 value: ""
              }));
            }else{
                $.get("/consultar/proveedores?idCategoria=" + idCategoria, function (data) {
                                //populateSelect("#select2", data);
                    $("#proveedorProducto").empty();
                    $("#proveedorProducto").append($('<option>', {
                            text: "Selecciona un proveedor...",
                             value: ""
                    }));
                    $.each(data, function (index, proveedor) {
                        $("#proveedorProducto").append($("<option>").text(proveedor[1]).val(proveedor[0]));
                    });
                });
            }
        });

//===========================================
    $('.roles_').hide();
//========================================


//=======================================
        $('[data-toggle="tooltip"]').tooltip();
//=======================================

new DataTable('#tablaCiudades', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});

new DataTable('#tablaRoles', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});

new DataTable('#myTable', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});

new DataTable('#tablaUsuarios', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});

new DataTable('#tablaClientes', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});

new DataTable('#tablaProductos', {
    language: {
        url: '//cdn.datatables.net/plug-ins/1.13.7/i18n/es-ES.json',
    },
});


        //$('#tablaCiudades').DataTable();
        //$('#tablaRoles').DataTable();
        //$('#myTable').DataTable();
        //$('#tablaUsuarios').DataTable();
        //$('#tablaClientes').DataTable();
        //$('#tablaProductos').DataTable();

//=======================================
        $("#ciudadUsuario").hide();

    var n = 1;
        while($("#ciudadUsuario_"+n).length > 0 || n <= 100){
                $("#ciudadUsuario_"+n).hide();

                //alert("#ciudadUsuario_"+n);

                n++;
              }

    var n2 = 1;
        while($("#ciudadUsuario2_"+n2).length > 0 || n <= 100){
                $("#ciudadUsuario2_"+n2).hide();

                //alert("#ciudadUsuario_"+n);

                n2++;
              }

//=======================================
setTimeout(function() {
     var index = 1;

        while(index < 1000){

           var id_role = 1;

            while(id_role < 10){

                if($(".role_"+index+"_"+id_role).length > 0){

                    //$("#role_"+index+"_"+id_role).prop('checked', true);
                    $("#role_"+index+"_"+id_role).trigger('click');
                }

                id_role++;
            }
            index++;
        }

}, 1000);

//=====================================

        setTimeout(function() {

            var numeroEstado = 1;
            while($("#estadoUsuario_"+numeroEstado).length > 0){
                   var valorEstado =  $("#estadoUsuario_"+numeroEstado).val();
                   $("#estadoUsuario_"+numeroEstado).val(valorEstado).trigger('change');

                 var valorCiudad = $("#ciudadUsuario_"+numeroEstado).val();

                   //$("#ciudad2Usuario_"+numeroEstado).val(valorCiudad);
                   $("#ciudad2Usuario_"+numeroEstado+" option[value='" + valorCiudad + "']").prop('selected', true);

                   numeroEstado++;
            }
          }, 1000);


          setTimeout(function() {

                      var numeroEstado2 = 1;
                      while($("#estadoUsuario2_"+numeroEstado2).length > 0){
                             var valorEstado =  $("#estadoUsuario2_"+numeroEstado2).val();
                             $("#estadoUsuario2_"+numeroEstado2).val(valorEstado).trigger('change');

                           var valorCiudad2 = $("#ciudadUsuario2_"+numeroEstado2).val();

                             //$("#ciudad2Usuario_"+numeroEstado).val(valorCiudad);
                             $("#ciudad22Usuario_"+numeroEstado2+" option[value='" + valorCiudad2 + "']").prop('selected', true);

                             numeroEstado2++;
                      }
                    }, 1000);

//====================================

       $('[id^="estadoUsuario_"]').on('change', function(){

            var id = $(this).attr('id');

            var idSeleccionado = $(this).children('option:selected').attr('id');

               var idDividido = id.split("_");

               $("#ciudad2Usuario_"+idDividido[1]+" option").remove();
               $("#ciudad2Usuario_"+idDividido[1]).append($('<option>', {
                     text: "Selecciona una ciudad...",
                     value: ""
               }));

               $("."+idSeleccionado).each(function() {

                    var texto = $(this).html();
                    var valor = $(this).val();

                    $("#ciudad2Usuario_"+idDividido[1]).append($('<option>', {
                              value: valor,
                              text: texto
                    }));
               });
      });

//===========================================
$('[id^="estadoUsuario2_"]').on('change', function(){

            var id2 = $(this).attr('id');

            var idSeleccionado2 = $(this).children('option:selected').attr('id');

               var idDividido2 = id2.split("_");

               $("#ciudad22Usuario_"+idDividido2[1]+" option").remove();
               $("#ciudad22Usuario_"+idDividido2[1]).append($('<option>', {
                     text: "Selecciona una ciudad...",
                     value: ""
               }));

               $("."+idSeleccionado2).each(function() {

                    var texto = $(this).html();
                    var valor = $(this).val();

                    $("#ciudad22Usuario_"+idDividido2[1]).append($('<option>', {
                              value: valor,
                              text: texto
                    }));
               });
      });

//===========================================

     $("#estadoUsuario").on("change", function(){

        $("#ciudadUsuario2 option").remove();
        $('#ciudadUsuario2').append($('<option>', {
                                text: "Selecciona una ciudad...",
                                value: ""
                            }));

       var idEstado =  $(this).val();


            $.get("api/v1/consultar/ciudades/estado?idEstado="+idEstado, function(data){

                $.each(data, function (index, ciudad) {
                    $("#ciudadUsuario2").append($("<option>").text(ciudad[1]).val(ciudad[0]));
                });

            });
      });

      $('#estadoUsuario').on('click', function() {
              //alert("click");
              //consultarEstados();
            });

consultarEstados();

function consultarEstados(){

 $.get("api/v1/consultar/estados/select", function (data) {

        $("#estadoUsuario").empty();
        $("#estadoUsuario").append($('<option>', {
            text: "Selecciona un estado...",
            value: ""
         }));

        $.each(data, function (index, estado) {

            $("#estadoUsuario").append($("<option>").text(estado[1]).val(estado[0]));
        });
   });
}
     //=======================================

    $("input[name$='tipoPersona']").click(function(){

            var tipoPersona = $(this).val();

            if( tipoPersona == 1){
            $(".usuarioSection").show();
            $("#userUsuario").attr("required", true);
            $("#passwordUsuario").attr("required", true);
            $("#roleUsuario").attr("required", true);

            $('.roles :checkbox').prop('required', true);
            $('.roles :checkbox').attr('required', 'required');

            }else if( tipoPersona == 2){
            $(".usuarioSection").hide();
            $("#userUsuario").attr("required", false);
            $("#passwordUsuario").attr("required", false);
            $("#roleUsuario").attr("required", false);

            $('.roles :checkbox[required]').prop("required", false);

            }
    });


    var inputElement = $("input[name$='roleUsuario']");
            if (inputElement.length > 0) {
                inputElement.attr('required', true);

            }

// ======================================================================================
// EVENTO QUE CONSULTA LOS ESTADOS QUE LLENAN EL 'SELECT' DE EDITAR USUARIO .
// ======================================================================================

//Funcion que consulta la lista de Estados para llenar el select para editar usuario.
consultarEstadosUsuario();
function consultarEstadosUsuario(){

    $.get("api/v1/consultar/estados/select", function (estados) {
            //populateSelect("#select1", data);
            $("#estadoUsuarioEdit").empty();
            $("#estadoUsuarioEdit").append($('<option>', {
                          text: "Selecciona un estado...",
                          value: ""
                 }));
            $.each(estados, function (index, estado) {

                 $("#estadoUsuarioEdit").append($("<option>").text(estado[1]).val(estado[0]));
            });
        });

}
// ======================================================================================
// EVENTO QUE CONSULTA LOS DATOS DE UN USUARIO PARA SER EDITADOS.
// ======================================================================================

     //se obtiene el id del usuario que comience con 'usuarioEdit_'
    //con le objetivo de identificar cual es el usuario que se desea editar
    $('a[id^="usuarioEdit_"]').click(function () {
           //se obtiene el id completo elemplo 'usuarioEdit_24'
         var usuario = $(this).attr('id');
         //se divide el usuario con split con el objetivo de encontrar el numero
         //de usuario que se desea consultar para posteriormente editar sus datos.
         var idUsuario = usuario.split("_");

        //se envia por medio de url el id del usuario como parametro
        //dicha url obtiene una consulta de tipo List<Object[]>
        //la cual devuelve una lista con un solo elemento en este caso
        //el usuario que coincida con el id seleccionado.
         $.get("consultar/usuario/completo?idUsuario="+(idUsuario[1]+""), function (data) {

                 $.each(data, function (index, personaUsuario) {

                    //asingar cada posicion del Object[] obtenido a los campos del formulario editar usuario
                     $("#idDireccionEdit").val(personaUsuario[5]);
                     $("#idPersonaEdit").val(personaUsuario[11]);
                     $("#idUsuarioEdit").val(personaUsuario[17]);

                     $("#nombreUsuarioEdit").val(personaUsuario[14]);
                     $("#apellidosUsuarioEdit").val(personaUsuario[15]);
                     $("#nacimientoUsuarioEdit").val(personaUsuario[12]);
                     $("#emailUsuarioEdit").val(personaUsuario[13]);
                     $("#estadoUsuarioEdit").val(personaUsuario[0]);
                     $("#calleUsuarioEdit").val(personaUsuario[9]);
                     $("#coloniaUsuarioEdit").val(personaUsuario[6]);
                     $("#numeroUsuarioEdit").val(personaUsuario[7]);
                     $("#codigoUsuarioEdit").val(personaUsuario[8]);
                     $("#userUsuarioEdit").val(personaUsuario[19]);
                     $("#passwordUsuarioEdit").val(personaUsuario[18]);

                     //se manda a llamar la siguiente función, la cual consulta las ciudades del estado seleccionado= personaUsuario[0]
                     //y se envia la ciudad a la que pertenece el usuario para llenar el select de ciudades y seleccionar por de fault la ciudad consultada= personaUsuario[2]
                     consultarCiudades(personaUsuario[0], personaUsuario[2]);

                     //se llama al medodo para imprimir todos los roles en el formulario.
                     //se envia como parametro el id del usuario para consultar los roles a los que esta asignado;
                     consultarRolesUsuarioEdit(personaUsuario[17]);

                 });
         });

     });

// ======================================================================================
// FUNCIÓN QUE CONSULTA LAS CIUDADES DEL ESTADO DEL USUARIO A EDITAR   .
// ======================================================================================

//La función recibe dos parametros el Estado y la ciudad consultada del usuario a editar
    function consultarCiudades(estadoSeleccionado, ciudadSeleccionada){

       $("#ciudadUsuarioEdit option").remove();

           $('#ciudadUsuarioEdit').append($('<option>', {
                   text: "Selecciona una ciudad...",
                   value: ""
           }));

    //funcion que consulta las ciudades por estado, recibiendo como parametro el estado al que pertenece el usuario
           $.get("api/v1/consultar/ciudades/estado?idEstado="+estadoSeleccionado, function(data){

                $.each(data, function (index, ciudad) {
            //Se recorren las ciudades con un $.each  y si la ciudad coincide con la ciudad de usuario, se selecciona en el select.
                    if(ciudadSeleccionada == ciudad[0]){
                         $("#ciudadUsuarioEdit").append($("<option>").text(ciudad[1]).val(ciudad[0]).prop('selected', true));

                    }else{
                        $("#ciudadUsuarioEdit").append($("<option>").text(ciudad[1]).val(ciudad[0]));
                    }
                });

           });
    }

// ======================================================================================
    // FUNCIÓN QUE CONSULTA LAS CIUDADES SEGUN EL ESTADO SELECCIONADO DEL SELECT DE EDITAR USUARIO  .
// ======================================================================================

//si el select de estados del formulario esitar usuario cambia, se consultan las ciudades segun sea el estado seleccionado
    $("#estadoUsuarioEdit").on("change", function(){
//primeramente se limpia el select de ciudades
       $("#ciudadUsuarioEdit option").remove();
//se agrega una opción por de fault
       $('#ciudadUsuarioEdit').append($('<option>', {
           text: "Selecciona una ciudad...",
           value: ""
       }));

//se obtiene el id del estado seleccionado, que es igual al valor seleccionado en el select.
      var idEstado =  $(this).val();

//en esta función se consultan las ciudades segun el id del estado
      $.get("api/v1/consultar/ciudades/estado?idEstado="+idEstado, function(data){

//se recorre cada elemento de la consulta y se agrega al select de ciudades un valor y un nombre por cada ciudad obtenida
         $.each(data, function (index, ciudad) {
           $("#ciudadUsuarioEdit").append($("<option>").text(ciudad[1]).val(ciudad[0]));
         });
      });
    });

// ======================================================================================
    // FUNCIÓN QUE CONSULTA TODOS LOS ROLES, Y LOS ROLES ASUGNADOS AL USUARIO, PARA EL FORMULARIO DE EDITAR USUARIO.
// ======================================================================================

//(Metoddo proveniente de RoleController)
//Esta función ejecuta dos funciones get anidadas, una para consultar todos los roles y otra que consulta los roles segun el idUsuario
//esto con el obetivo de seleccionar los roles a los que el usuario esta asignado para poder editarlos.

    function consultarRolesUsuarioEdit(idUsuario){

//funcion que consulta los roles a los que esta asignado el usuario
        $.get("/consultar/roles/usuarioEdit?id_user="+idUsuario, function (data){

            var rolesUsuario = "";
//se recorren los roles a los que esta asignado el usuario y se van concatenando a la varialeble rolesUsuario
//agregando una coma entre cada rol obtenido.
            $.each(data, function (index, rol) {
                rolesUsuario += rol[0]+",";
            });

//la cadena de roles creada se divide con el metodo split esto con el objetivo de crear un arreglo de roles
// el cual dentro de la funcion (consultan todos los roles) se comparará con cada rol para asingarle la propiedad checked
            var arregloRolesUsuario = rolesUsuario.split(",");


//Se consultan todos los roles de la lista
        $.get("/consultar/todos/roles", function (data) {
//cada que se consulta un nuevo usuario se vacia el div en donde se imprimen los roles
            $('#rolesConsultados').empty();
            $('#rolesConsultados').append($('<br/>'));

           $.each(data, function (index, rol) {
//Para cada rol se crea un div, un input tipo checkbox, al checkbox se le agrega
//su atributo id, name y un valor, se crear un label  para dicho checkbox.
//(se agrega la clase roles_seleccionados para poder identificar los roles que se encontraran dentro del div)
               var wrapCheckbox = $('<div>').addClass('form-check form-switch roles_seleccionados');
               var checkbox = $('<input type="checkbox">').addClass('form-check-input');
                   checkbox.attr('id', rol[0]);
                   checkbox.attr('name', 'role_usuario');
                   checkbox.val(rol[0]);
                 //checkbox.prop('required', true);

//aqui se verifica si en el arreglo creado en la función externa se encuentra el rol que esta siendo imprimido
//si el rol se encuentra en el arreglo se le asigna la propiedad  checked = true, con el objetivo
//de marcar los roles a los que se encuentra asignado el usuario y poder editarlos.
                   if ($.inArray(rol[0]+"", arregloRolesUsuario) !== -1) {
                     checkbox.prop('checked', true);
                   }

               var label = $('<label>').addClass('form-check-label').text(rol[1]);
//se añade al div creado el checkbox y el label
               wrapCheckbox.append(checkbox);
               wrapCheckbox.append(label);
//el div creado se añade al div que se creo en el html para imprimir los roles.
               $('#rolesConsultados').append(wrapCheckbox);

            });
        });
     });
   }

// ======================================================================================
     // VALIDACIÓN QUE PERMITE HACER REQUERIDOS O NO LOS CHECKBOX DE LOS ROLES DEL FORMULARIO EDITAR USUARIO.
// ======================================================================================

//Dentro del evento submit antes de enviar la información para ser actualizada se validan que los roles sean requeridos o no.
   $("#usuarioFormEdit").submit(e => {
       e.preventDefault();
//Se consulta la cantidad de checkbox que se encuentren seleccionados ubicados dentro de div con la clase  "roles_seleccionados"
//con el objetivo de validar cuando los checkbox seran requeridos o no.
       var cantidadCheckboxesMarcados = $('div.roles_seleccionados input[type="checkbox"]:checked').length;

//Si no existen checkboxes seleccionados, entonces a todos se les aplica la propiedad requerido en true.
       if (cantidadCheckboxesMarcados === 0) {
// Ningún checkbox está marcado, asignar el atributo "required"
          $('div.roles_seleccionados input[type="checkbox"]').prop('required', true);
//Si existe al menos un checkbox seleccionado entonces la propiedad de los checkbox requerido pasa a ser false.
       } else if (cantidadCheckboxesMarcados > 0) {
// Al menos un checkbox está marcado, quitar el atributo "required"
          $('div.roles_seleccionados input[type="checkbox"]').prop('required', false);

       }


//Si un checkbox con el nombre "role_usuario" cambia se verifica si al menos existe un checkbox seleccionado
//en caso de que sea así a los demas checkbox que no estan seleccionados se les aplica la propiedad requerido en false
        $('input[name="role_usuario"]').change(function() {

//si la cantidad de checkbox  seleccionados es mayor a cero los demas checkbox no seleccionados dejan de ser requeridos.
              if ($('input[name="role_usuario"]:checked').length > 0) {
                        // Quitar la propiedad 'required' de los demás checkboxes
                 $('input[name="role_usuario"]').not(':checked').prop('required', false);

//de lo contrario si no existen checkbox seleccionados, entonces todos serán requeridos.
              } else {
                        // Si ninguno está seleccionado, restaurar la propiedad 'required' a todos los checkboxes
                 $('input[name="role_usuario"]').prop('required', true);

              }
        });

// SECCIÓN PARA ENVIAR LOS DATOS DEL FORMULARIO EDITAR USUARIO

//Se serializan los datos del formulario, es decir que obtienen los valores de cads input y se convierten una cadena de elementos clave-valor
         var datosFormEdit = $("#usuarioFormEdit").serialize();

//se envian por medio de la función $.ajax, un metodo de tipo POST, con el contenido del formulario.
         $.ajax({
            type: "POST",
            url: "/guardar/persona",
            data: datosFormEdit,
            success: function (response) {
//Si la respuesta es exitosa se muestra un alert, y se cierra el modal.
                Swal.fire({
                   title: "El Usuario se actualizó correctamente",
                   icon: "info"
                });

                $('#cerrarUsuarioEditBtn').click();
            },
            error: function (error) {
                // Manejar errores, si es necesario
                console.error(error);
            }
         });
     });

// ======================================================================================
// FUNCIÓN QUE CONSULTA LAS CIUDADES DEL ESTADO DEL CLIENTE A EDITAR   .
// ======================================================================================

//La función recibe dos parametros el Estado y la ciudad consultada del usuario a editar
    function consultarCiudadesCliente(estadoSeleccionado, ciudadSeleccionada){

       $("#ciudadUsuarioEdit2 option").remove();

           $('#ciudadUsuarioEdit2').append($('<option>', {
                   text: "Selecciona una ciudad...",
                   value: ""
           }));

    //funcion que consulta las ciudades por estado, recibiendo como parametro el estado al que pertenece el usuario
           $.get("api/v1/consultar/ciudades/estado?idEstado="+estadoSeleccionado, function(data){

                $.each(data, function (index, ciudad) {
            //Se recorren las ciudades con un $.each  y si la ciudad coincide con la ciudad del usuario, se selecciona en el select.
                    if(ciudadSeleccionada == ciudad[0]){
                         $("#ciudadUsuarioEdit2").append($("<option>").text(ciudad[1]).val(ciudad[0]).prop('selected', true));

                    }else{
                        $("#ciudadUsuarioEdit2").append($("<option>").text(ciudad[1]).val(ciudad[0]));
                    }
                });

           });
    }

// ======================================================================================
// EVENTO QUE CONSULTA LOS ESTADOS QUE LLENAN EL 'SELECT' DE EDITAR CLIENTE .
// ======================================================================================

//Funcion que consulta la lista de Estados para llenar el select para editar cliente.
    consultarEstadosCliente();
    function consultarEstadosCliente(){

    $.get("api/v1/consultar/estados/select", function (estados) {
//se vacia el select y se establece una opción por de fault.
            $("#estadoUsuarioEdit2").empty();
            $("#estadoUsuarioEdit2").append($('<option>', {
                          text: "Selecciona un estado...",
                          value: ""
                 }));
//la funcion anterior devuelve una List<Object[]>  (estados) la cual debe ser iterada para obtener cada estado.
//se añade al select una nueva opción con el texto y valor obtenidos de la lista de estados.
            $.each(estados, function (index, estado) {

                 $("#estadoUsuarioEdit2").append($("<option>").text(estado[1]).val(estado[0]));
            });
        });
    }

// ======================================================================================
    // FUNCIÓN QUE CONSULTA LAS CIUDADES SEGUN EL ESTADO SELECCIONADO DEL SELECT DE EDITAR CLIENTE  .
// ======================================================================================

//si el select de estados del formulario editar cliente cambia, se consultan las ciudades segun sea el estado seleccionado
    $("#estadoUsuarioEdit2").on("change", function(){
//primeramente se limpia el select de ciudades
       $("#ciudadUsuarioEdit2 option").remove();
//se agrega una opción por de fault
       $('#ciudadUsuarioEdit2').append($('<option>', {
           text: "Selecciona una ciudad...",
           value: ""
       }));

//se obtiene el id del estado seleccionado, que es igual al valor seleccionado en el select.
      var idEstado =  $(this).val();

//en esta función se consultan las ciudades segun el id del estado
      $.get("api/v1/consultar/ciudades/estado?idEstado="+idEstado, function(data){

//se recorre cada elemento de la consulta y se agrega al select de ciudades un valor y un nombre por cada ciudad obtenida
         $.each(data, function (index, ciudad) {
           $("#ciudadUsuarioEdit2").append($("<option>").text(ciudad[1]).val(ciudad[0]));
         });
      });
    });

//=======================================================================================
//EVENTO QUE CONSULTA LOS DATOS DE UN CLIENTE PARA SER EDITADOS
//=======================================================================================

//Se detecta cuando se le ha dado click a un elemento tipo <a> el cual su id comience con "clienteBtn_"
//Lo cual significará que se esta haciendo click a un botón de la tabla "Listado de Clientes,
//con el objetivo de consultar su datos para poder editarlos.
    $('a[id^="clienteBtn_"]').click(function () {
//Se obtiene el id del botón presionado
        var cliente = $(this).attr('id');
//como el id del botón esta compuesto de esta manera clienteBtn_10, se realiza un split
//para dividir el id y obtener el numero, que en este caso es el numero de cliente (id).
        var idCliente = cliente.split("_")[1];
//Por medio del método get, se consultan los datos de cliente enviado el id obtenido del split.
        $.get("consultar/cliente/completo?idUsuario="+(idCliente+""), function (data) {

//Se recorrer List<Object[]> obtenida y se asigna a cada id (campo) del formulario editar cliente el valor indicado.
            $.each(data, function (index, personaCliente) {

                $("#idDireccionEdit2").val(personaCliente[5]);
                $("#idPersonaEdit2").val(personaCliente[11]);
                $("#idUsuarioEdit2").val(personaCliente[17]);

                $("#nombreUsuarioEdit2").val(personaCliente[14]);
                $("#apellidosUsuarioEdit2").val(personaCliente[15]);
                $("#nacimientoUsuarioEdit2").val(personaCliente[12]);
                $("#emailUsuarioEdit2").val(personaCliente[13]);
                $("#estadoUsuarioEdit2").val(personaCliente[0]);
                $("#calleUsuarioEdit2").val(personaCliente[9]);
                $("#coloniaUsuarioEdit2").val(personaCliente[6]);
                $("#numeroUsuarioEdit2").val(personaCliente[7]);
                $("#codigoUsuarioEdit2").val(personaCliente[8]);

//se manda a llamar la siguiente función, la cual consulta las ciudades del estado seleccionado: personaCliente[0]
//y se envia la ciudad a la que pertenece el cliente para llenar el select de ciudades y seleccionar por de fault la ciudad consultada: personaCliente[2]
                consultarCiudadesCliente(personaCliente[0], personaCliente[2]);

            });

        });

    });

//=======================================================================================
//EVENTO QUE REALIZA EL ENVIO DE DATOS DEL FORMULARIO DEL CLIENTE
//=======================================================================================
    $("#clienteFormEdit").submit(e => {
           e.preventDefault();

//Se serializan los datos del formulario, es decir se tranforman en una cadena de claves = valor,
//con el objetivo de enviar toda la información de los campos. Nombre del input y su valor.
        var datosFormEdit = $("#clienteFormEdit").serialize();

//se envia el formulario serializado por medio del metodo ajax.
        $.ajax({
            type: "POST",
            url: "/guardar/persona",
            data: datosFormEdit,
            success: function (response) {
        //Si la respuesta es exitosa se muestra un alert, y se cierra el modal.
                Swal.fire({
                    title: "El Cliente2 se actualizó correctamente",
                    icon: "info"
                });

                $('#cerrarClienteEditBtn').click();
            },
            error: function (error) {
            // Manejar errores, si es necesario
                console.error(error);
            }
        });
    });
});