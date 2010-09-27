//
// IMEのメイン画面
//
package com.pitecan.helloime;
//
import android.view.View;
import android.view.MotionEvent;
import android.graphics.Canvas;
import android.content.Context;
import android.util.AttributeSet;
//
public class HelloIMEView extends View {
 HelloIME helloIME;
 public HelloIMEView(Context context, AttributeSet attrs) {
  super(context,attrs);
  }
 @Override public void onDraw(Canvas canvas) {
  canvas.drawColor(0xffe0e0e0 /* [[http://gyazo.com/299bbb92a11833c1d2a6bfff1285659f.png]] */);
  }
 @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
  setMeasuredDimension(widthMeasureSpec,80);
  }
 public boolean onTouchEvent(MotionEvent ev) {
  if((ev.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
   helloIME.input("ミサワ! "); // [[http://gyazo.com/e9c5df96c6303572844834fa8588b60e.png]]
   }
  return true;
  }
 public void setIME(HelloIME _helloIME){
  helloIME = _helloIME;
  }
 }
