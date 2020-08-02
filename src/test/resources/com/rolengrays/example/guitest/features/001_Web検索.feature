#language: ja
機能: Web検索

  シナリオテンプレート: Google検索
    前提 Google検索ページを開く
    もし Google検索ページに<word>を入力して検索する
    ならば Google検索結果が表示される
    かつ Google検索結果に<title>がヒットする

    サンプル:
    | word | title |
    | "ネコ" | "ネコ - Wikipedia" |
    | "チンチラ" | "チンチラ - Wikipedia" |


  シナリオテンプレート: GoogleとBingの検索トップ
    前提 Google検索ページを開く
    もし Google検索ページに<word>を入力して検索する
    かつ Google検索結果が表示される
    前提 Bing検索ページを開く
    もし Bing検索ページに<word>を入力して検索する
    かつ Bing検索結果が表示される
    ならば GoogleとBingの検索結果トップが一致する

    サンプル:
    | word |
    | "cucumber" |