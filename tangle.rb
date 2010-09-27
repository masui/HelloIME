#
# Gyazzからソースファイルを取得する
# [[http://ja.wikipedia.org/wiki/%E6%96%87%E8%8A%B8%E7%9A%84%E3%83%97%E3%83%AD%E3%82%B0%E3%83%A9%E3%83%9F%E3%83%B3%E3%82%B0 文芸的プログラミング]]をWikiで実現する!
#
require 'fileutils'
require 'open-uri'
wiki = 'http://Gyazz.com/HelloIME'
rootpage = 'Index'
def valid(path) # 拡張子があるもの
 path =~ /\.[a-zA-Z]+$/
end
def create(wiki,path)
 STDERR.puts path
 if path =~ /^(.*)\/([^\/]+)$/ then
   FileUtils.mkdir_p($1)
 end
 if path =~ /(png|jpg)/i then # 画像の場合はページ内の画像を取得
  open("#{wiki}/#{path}/text").each{ |line|
   if line =~ /\[\[(.*\.(png|jpg))\]\]/ then
    imagefile = $1
    image = open(imagefile).read
    File.open(path,"w"){ |outfile|
     outfile.print image
    }
   end
  }
 else
  File.open(path,"w"){ |outfile|
   open("#{wiki}/#{path}/text").each{ |line|
    outfile.puts line
   }
  }
 end
end
open("#{wiki}/#{rootpage}/text").each{ |line|
 if line =~ /\[\[([^\[]+)\]\]/ then
  path = $1
  if path !~ /^http/ then
   create(wiki,path) if valid(path)
  end
 end
}
