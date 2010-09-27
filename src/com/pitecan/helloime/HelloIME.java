// [[http://gyazo.com/55d3cfae7cd3ccdf7489b2dfc50b7530.png]]
//
// タ ッチすると常に「Hello, World」という文字が入力されるネタIME
//
// [[http://www.techdoctranslator.com/resources/articles/articles-index/creating-input-method IMEドキュメント]]に書かれているようなメソッドを普通はいろいろ使うのだがaaaaaaa
//
// このサンプルでは絶対必要なものだけ使っている。
//
// [[http://gyazo.com/eb908e4ab8dff1c269577ef52d30f008.png]]
package com.pitecan.helloime;
//
import android.inputmethodservice.InputMethodService;
import android.view.View;
//
public class HelloIME extends InputMethodService
{
 HelloIMEView helloIMEView;
 @Override public View onCreateInputView() {
  helloIMEView = (HelloIMEView) getLayoutInflater().inflate(R.layout.input, null);
  helloIMEView.setIME(this);
  return helloIMEView;
  }
 public void input(String s){
  getCurrentInputConnection().commitText(s,1); // 入力貼り付け
  }
 }
// [[http://gyazo.com/741eca3c91b94ac27785d8e0e93978f9.png]]
