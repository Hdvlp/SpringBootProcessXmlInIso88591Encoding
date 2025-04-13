
# For development purposes, the Java source code is in UTF-8 encoding.

# Perhaps some applications were developed with "ISO-8859-1" without considering "UTF-8."

# In PowerShell, you might want to learn more about file encoding:
# https://learn.microsoft.com/en-us/powershell/scripting/dev-cross-plat/vscode/understanding-file-encoding?view=powershell-7.5
# "ISO-8859-1" is used like this to display properly:

[Console]::InputEncoding = [System.Text.Encoding]::GetEncoding("ISO-8859-1");
[Console]::OutputEncoding = [System.Text.Encoding]::GetEncoding("ISO-8859-1");
$PSDefaultParameterValues = @{
    "Out-File:Encoding" = "Latin1";
    "Set-Content:Encoding" = "Latin1"
}
./mvnw spring-boot:run

