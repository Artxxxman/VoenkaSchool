var productsInOrder = [];

function addProductInOrder(id,name,quantity,price) {
    var obj={
        id:id,
        name:name,
        quantity:quantity,
        price:price
    }
    var sum=0;
    if(isEmpty(productsInOrder)) {
        productsInOrder[productsInOrder.length] = obj
    }
    else {
        try {
            productsInOrder.forEach(function (item) {
                if (item.id == obj.id) {
                    item.quantity = item.quantity + obj.quantity
                    getCash()
                    throw BreakException;
                }
            })
            productsInOrder[productsInOrder.length] = obj
        }
        catch (e){
            if(e == BreakException) {
                throw e;
            }
        }
    }
    getCash()
}

function printProductsList() {

        $("#orderTable").html('')
        var items = ''
        productsInOrder.forEach(function (item) {
            items += '<tr>'
            items += '<td>'
            items += item.name
            items += '</td>'
            items += '<td>'
            items += item.quantity
            items += '</td>'
            items += '<td>'
            items += item.price
            items += '</td>'
            items += '<td>'
            items += (item.price*item.quantity)
            items += '</td>'
            items += '</tr>'
        })
        $("#orderTable").html(items)
}
function printStartPage() {
    getProducts(1,1);
    getCategories();
}
function getProducts (category,page) {
        $.ajax({
            url: "/juniorapp/loadproducts",
            data: {categoryId: category},
            contentType: "application/json",
            dataType: "json",
            type: 'GET',
            success: function (data) {

                $("#imagebox1").html('');
                $("#imagebox2").html('');
                $("#page").html('')
                var items='';
                var count = 0;
                var countObj =0;
                var box = '#imagebox1'
                try {
                    data.forEach(function (item) {
                        ++count
                        if(count<page) return;
                        items += '<div class="col-sm-4">'
                        items += '<div class="row">'
                        items+='<h4 class="text-center">'
                        items+=item.name
                        items += '</h4>'
                        items+='<h4 class="text-center">'
                        items+=item.price
                        items += 'p</h4>'
                        items += '</div>'
                        items += '<div class="row">'
                        items += '<form role="form" class="form-inline" >'
                        items += '<ul class="pager">'
                        items += '<li class="previous"><button type="submit" class="btn">←</button></li>'
                        items += '<li><input  ></li>'
                        items += '<li class="next"><button type="submit" class="btn">→</button></li>'
                        items += '<li><a href="#" onclick="addProductInOrder('+item.id+',\''+item.name+'\',1,'+item.price+')">+</a></li>'
                        items += '</ul>'
                        items += '</form>'
                        items += '</div>'
                        items += '</div>'
                        if (count % 3 == 0) {
                            $(box).html(items)
                            if (box != '#imagebox2') {
                                box = '#imagebox2'
                                items = ''
                            }
                            else
                            {
                                printPager(category,page,data)
                                throw BreakException;
                            }
                        }
                    })
                    $(box).html(items)
                    printPager(category,page,data)
                }
                catch (e){
                    if(e == BreakException) {
                        throw e;
                    }
                }

            }
        });
}
function getCategories() {
        $.ajax({
            url: "/juniorapp/homepage",
            contentType: "application/json",
            dataType: "json",
            type: 'GET',
            success: function (data) {
                var items = '<ul id="menu">'
                items += '<li class="categorytitle">Категории</li>';
                var count=0;
                $.each(data, function (key, val) {
                    ++count;
                    items += '<li><a href="#" onclick="getProducts('+count+',1)">' + val + '</a></li>';
                });
                items += '</ul>'
                $("#blockmenu").html(items);
            }
        });
}
function getCash() {
    $("#cash").html('');
    var sum=0;
    if(isEmpty(productsInOrder)) {
        sum=0;
    }
    else {
        productsInOrder.forEach(function (item) {
            sum += item.price * item.quantity
        })
    }
    var html = '<h4>корзина['+sum+'p]</h4>';
    $("#cash").html(html);
}
function printPager(category,page,data){
    var items='';
    items+='<div class="col-sm-12">'
    items+='<ul class="pager" id="page">'
    if(page-6>0) {
        items += '<li class="previous"><a href="#" onclick="getProducts(' + category + ','+(page-6)+')">← Предыдущая</a></li>'
    }
    if(data.length>=page+6) {
        items += '<li class="next"><a href="#" onclick="getProducts(' + category + ','+(page+6)+')">Следующая →</a></li>'
    }
    items+='</ul>'
    items+='</div>'
    $("#page").html(items)
}

function isEmpty(obj) {
    for (var key in obj) {
        return false;
    }
    return true;
}
$(document).ready(function() {
    $('a#go').click( function(event){
        event.preventDefault();
        $('#overlay').fadeIn(400,
            function(){
                $('#modal_form')
                    .css('display', 'block')
                    .animate({opacity: 1, top: '50%'}, 200);
            });
        printProductsList()
    });

    $('#modal_close, #overlay').click( function(){
        $('#modal_form')
            .animate({opacity: 0, top: '45%'}, 200,
                function(){ 
                    $(this).css('display', 'none');
                    $('#overlay').fadeOut(400);
                }
            );
    });
});

