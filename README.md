# InformationHandling
Разработать приложение, разбирающее и обрабатывающее текст.

Необходимо создать приложение, разбирающее текст из файла и позволяющее выполнять с текстом три различных операции. 

Общие требования к проекту:
Разобранный текст должен быть представлен в виде объекта (текста), содержащего, например, предложения и блоки кода, предложение может содержать слова предложения. Слова предложения (части предложения), могут быть, например, простыми словами и знаками препинания. Данные классы являются классами сущностей и не должны быть перегружены методами логики.
Разобранный текст необходимо восстановить в первоначальном виде, за исключением пробелов между элементами. Математические выражения должны быть вычислены. Пробелы и знаки табуляции при разборе могут заменяться одним пробелом.
Для деления текста на предложения и другие составляющие следует использовать регулярные выражения. Не забывать, что регулярные выражения для приложения являются литеральными константами.
Код, выполняющий разбитие текста на составляющие части, следует оформить в виде классов-парсеров.
При разработке парсеров, разбирающих текст, необходимо следить за количеством создаваемых объектов-парсеров.
При реализации задания можно использовать шаблоны Composite и Chain of Responsibility.
При обработке исключительных ситуаций приложение необходимо использовать логгер Log4j.
Созданное приложение должно позволять реализовывать группу задач по работе над текстом (задачи приведены ниже) без “переписывания” существующего кода.

Функциональные возможности:
1. Вывести все предложения заданного текста в порядке возрастания 
количества слов в каждом из них.
2. В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
3. Из текста удалить все лексемы заданной длины, начинающиеся на заданную букву.

Пример текста для обработки:
	It has survived not only five centuries, but also the leap into 13+(3++) electronic --3 typesetting, remaining 3+5- essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5-4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
	It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (0-(2*2*(3*(2-1/2*2)-2)-10/2))*(++5) Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.
	It is a (-5+1/2*(2+5*2))*1200 established fact that a reader will be of a page when looking at its layout.
	Hello.
