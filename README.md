# 初級課題１

## 工夫
inputのバリデーションは別ファイル。

## 【質問】
Srcフォルダーにcalculator,student_list,inputUtil、３つのファイルを入れてみましたが、初めに作ったcaluculatorしか動かず。

今回はそれぞれのプロジェクトでファイルを作っていますが、inputUtil.javaを複数のプロジェクトでまたがって使ったりすることは可能ですか？
↓  
ChatGTPに聞いた回答が以下なのですが、このようなやり方が一般的ですか？   
🔸 方法②：共通ユーティリティプロジェクトを作って依存関係として使う（本格的なやり方）
InputUtil だけを含むプロジェクト（例：common-utils）を作成

他のプロジェクトから common-utils を参照（クラスパスに追加）
```
[bash]
javac InputUtil.java
jar cf inpututil.jar InputUtil.class
```
  
そして他のプロジェクトで：
```
[bash]
javac -cp ./libs/inpututil.jar StudentList.java
java -cp .:./libs/inpututil.jar StudentList
```
