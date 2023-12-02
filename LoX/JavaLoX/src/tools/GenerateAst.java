package tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        args = new String[]{"src/ast"};

        String outputDir = args[0];
        defineAst(outputDir, "Expression", Arrays.asList(
                "BinaryExp   : Expression left, Token operator, Expression right",
                "GroupingExp : Expression expression",
                "LiteralExp  : Object value",
                "UnaryExp    : Token operator, Expression right"
        ));
    }

    private static void defineAst(String outputDir, String baseName, List<String> types) throws IOException {
        String path = outputDir + "/" + baseName + ".java";
        PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);

        writer.println("package ast;");
        writer.println();
        writer.println("import visitors.*;");
        writer.println("import token.Token;");
        writer.println("import java.util.List;");
        writer.println();
        writer.println("public abstract class " + baseName + " {");

        // The AST classes.
        for (String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(writer, baseName, className, fields);
        }

        // The base accept() method.
        writer.println();
        writer.println("  public abstract <R> R accept(ExpressionVisitor<R> expressionVisitor);");

        writer.println("}");
        writer.close();
    }


    private static void defineType(PrintWriter writer, String baseName, String className, String fieldList) {
        writer.println("  public static class " + className + " extends " + baseName + " {");

        // Constructor.
        writer.println("    " + className + "(" + fieldList + ") {");

        // Store parameters in fields.
        String[] fields = fieldList.split(", ");
        for (String field : fields) {
            String name = field.split(" ")[1];
            writer.println("      this." + name + " = " + name + ";");
        }

        writer.println("    }");

        // Visitor pattern.
        writer.println();
        writer.println("    @Override");
        writer.println("    public <R> R accept(ExpressionVisitor<R> expressionVisitor) {");
        writer.println("      return expressionVisitor.visit" + className + baseName + "(this);");
        writer.println("    }");

        // Fields.
        writer.println();
        for (String field : fields) {
            writer.println("    final " + field + ";");
        }

        writer.println("  }");
    }
}
