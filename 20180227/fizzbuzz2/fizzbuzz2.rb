# -*- encoding: utf-8 -*-
# 応用問題
def main
  values = (1..100).map {|i|
    i_name = i.to_s
    three = i_name =~ /3/ || i % 3 == 0
    five = i_name =~ /5/ || i % 5 == 0
    if three && five
      'FizzBuzz'
    elsif five
      'Buzz'
    elsif three
      'Fizz'
    else
      i
    end
  }
  puts values
end

case $PROGRAM_NAME
when __FILE__
  main
when /spec[^\/]*$/
  # {spec of the implementation}
end




# >> 1
# >> 2
# >> Fizz
# >> 4
# >> Buzz
# >> Fizz
# >> 7
# >> 8
# >> Fizz
# >> Buzz
# >> 11
# >> Fizz
# >> Fizz
# >> 14
# >> FizzBuzz
# >> 16
# >> 17
# >> Fizz
# >> 19
# >> Buzz
# >> Fizz
# >> 22
# >> Fizz
# >> Fizz
# >> Buzz
# >> 26
# >> Fizz
# >> 28
# >> 29
# >> FizzBuzz
# >> Fizz
# >> Fizz
# >> Fizz
# >> Fizz
# >> FizzBuzz
# >> Fizz
# >> Fizz
# >> Fizz
# >> Fizz
# >> Buzz
# >> 41
# >> Fizz
# >> Fizz
# >> 44
# >> FizzBuzz
# >> 46
# >> 47
# >> Fizz
# >> 49
# >> Buzz
# >> FizzBuzz
# >> Buzz
# >> FizzBuzz
# >> FizzBuzz
# >> Buzz
# >> Buzz
# >> FizzBuzz
# >> Buzz
# >> Buzz
# >> FizzBuzz
# >> 61
# >> 62
# >> Fizz
# >> 64
# >> Buzz
# >> Fizz
# >> 67
# >> 68
# >> Fizz
# >> Buzz
# >> 71
# >> Fizz
# >> Fizz
# >> 74
# >> FizzBuzz
# >> 76
# >> 77
# >> Fizz
# >> 79
# >> Buzz
# >> Fizz
# >> 82
# >> Fizz
# >> Fizz
# >> Buzz
# >> 86
# >> Fizz
# >> 88
# >> 89
# >> FizzBuzz
# >> 91
# >> 92
# >> Fizz
# >> 94
# >> Buzz
# >> Fizz
# >> 97
# >> 98
# >> Fizz
# >> Buzz
