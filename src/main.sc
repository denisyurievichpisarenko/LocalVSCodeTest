require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Начнём.

    state: Hello
        intent!: /привет
        a: Привет привет

    state: Bye
        intent!: /пока
        a: Пока пока

    state: Word
        q!: * скажи* [люб*/случайн*] (слов*/что*) *
        random:
            a: Облако
            a: Озеро
            a: Башня
        go!: /Else
    
    state: Else
        a: Что-то ещё?
        buttons:
            "Да" -> "/Hello"
            "Нет" -> "/Bye"

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}