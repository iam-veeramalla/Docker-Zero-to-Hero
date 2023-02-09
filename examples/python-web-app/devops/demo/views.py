from django.http import HttpResponse


def index(request):
    return render(request, 'static/demo_site.html')
