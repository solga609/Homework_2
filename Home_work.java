
// Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
//  используя StringBuilder. Данные для фильтрации 
// приведены ниже в виде json строки.


public class Home_work {

  

    public static final String Word = "select * from students where ";
    public static final String parametrs = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
    
    public static void main(String[] args) {
        String paramsNew = parametrs.replace('{', ' ').replace('}', ' ');
    
        String[] params = paramsNew.split(",");
        StringBuilder stringBuilder = new StringBuilder(Word);
        for (int i = 0; i < params.length; i++) {
            String[] elements = params[i].replace('"', ' ').split(":");
            if (!"null".equals(elements[1].trim())) {
                stringBuilder.append(elements[0].trim()).append("=").append("'").append(elements[1].trim()).append("'");
                if (i < params.length - 2)
                    stringBuilder.append(" and ");
            }
        }
        System.out.println(stringBuilder);
    }
}

