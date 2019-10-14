/**
 * Some Groovy samples
 * Oct 2019 TEY
 */

// Some printing
println "Hello, World!"
println 1 + 2

// Java Date class can be used without import libs
today = new Date()
println(today)

// Closure that performs file printing
def number=0
new File ('GroovyTest.groovy').eachLine { line ->
    number++
    println "$number: $line"
}

// Working with list: show packages of some classes
def classes = [String, List, File]
for (clazz in classes)
{
    println clazz.'package'.name
}

// The same packages printing by accessing list properties
println( [String, List, File].'package'.name )

// XML-file reading
def customers = new XmlSlurper().parse(new File('customers.xml'))
for (customer in customers.corporate.customer)
{
    println "${customer.@name} works for ${customer.@company}"
}

// Print all files in folder and subfolders
new File('.').eachFileRecurse { println it }

/** the same in Java
public class ListFiles {
    public static void main(String[] args) {
        new java.io.File(".").eachFileRecurse(
                new FileListener() {
                    public void onFile (File file) {
                        System.out.println(file.toString());
                    }
                }
        );
    }
} */

// Cycle: Show 10 Fibonacci numbers
current = 1
next = 1
10.times {
    print current + ' '
    newCurrent = next
    next = next + current
    current = newCurrent
}
println ''
