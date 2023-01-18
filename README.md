# Minecraft_IPSheet_Spigot
スプレッドシートに書いたIP以外からはMinecraftサーバーにログインできないようにするプラグイン
## 使い方
- Google Drive に [Spreadsheet/IP_Sheets.xlsx](Spreadsheet/IP_Sheets.xlsx) を アップロード
- Google Drive に Google Apps Script を作成
- 作成した Google Apps Script に [GASファイル](GAS) にある jsファイルを [この画像](https://i.imgur.com/kIEYb3e.png) のように 貼り付ける
- Google Apps Script に作成した [config.gs](GAS/config.js) の SpreadsheetID を<br>Google Drive にアップロードした [IP_Sheets.xlsx](Spreadsheet/IP_Sheets.xlsx) の スプレッドシートID にする
- Google Apps Script の `デプロイ` から `新しいデプロイ` を選択し、<br>`種類の選択` から `ウェブアプリ`を選択 説明 に 何か書きたい場合は 記入し、`デプロイ`を押す
- `アクセスできるユーザー`を`全員`に設定する
- プラグインの [config.yml の URL](src/main/resources/config.yml#L1) という項目に 生成されたウェブアプリのURLを 貼り付け
- これで Google Drive にアップロードした [IP_Sheets.xlsx](Spreadsheet/IP_Sheets.xlsx) に書いてある IP からは ログインできなくなる
