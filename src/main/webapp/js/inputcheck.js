(function($) {
    //指定要素を定義
    const target = '#addForm input:required'; 
    
    //キー操作、状態変化をトリガーに実行
    $(target).on('keydown keyup keypress change', function(){

        //判定用のフラグ
        let flag = true;

        //指定要素をループで１つずつ確認
        $(target).each(function(e) {
            if ($(target).eq(e).val() === "") {
                flag = false;
            }
        });

        //フラグをみてtrueなら送信ボタンを有効。falseなら無効にする
        if (flag) {
            //必須項目すべて入力済みであれば有効にする
            $('#submitBtn').removeClass("disabled");
        }
        else {
            //未入力など漏れがある場合は無効にする
            $('#submitBtn').addClass("disabled");
        }
    });
    
     $('#stock_num').on('mouseup keyup', function(e){
	    var stockNum = parseInt($(this).val());
	    var stockNumMin = parseInt($(this).attr('min'));
	    if(stockNum < stockNumMin ){ $(this).val(stockNumMin); }
	    if(isNaN(stockNum)){ $(this).val('1'); }
	  });

})(jQuery);